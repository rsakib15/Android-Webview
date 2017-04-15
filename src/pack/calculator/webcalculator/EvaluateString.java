package pack.calculator.webcalculator;

import java.util.Stack;
import java.util.StringTokenizer;

public class EvaluateString{
    public  double evaluate(String expression){
        expression=expression.replaceAll("[\t\n ]", "")+"=";
        String operator="*/+-=";
        StringTokenizer tokenizer=new StringTokenizer(expression, operator, true);
        Stack operatorStack=new Stack();
        Stack valueStack=new Stack();
        while(tokenizer.hasMoreTokens()){
            String token=tokenizer.nextToken();
            if(operator.indexOf(token)<0)
                valueStack.push(token);
            else
                operatorStack.push(token);
            resolve(valueStack, operatorStack);
        }
        String lastOne=(String)valueStack.pop();
        return Double.parseDouble(lastOne);
    }

    public int getPriority(String op){
        if(op.equals("*") || op.equals("/"))
            return 1;
        else if(op.equals("+") || op.equals("-"))
            return 2;
        else if(op.equals("="))
            return 3;
        else
            return Integer.MIN_VALUE;
    }

    public void resolve(Stack values,Stack operators){
        while(operators.size()>=2){
            String first=(String)operators.pop();
            String second=(String)operators.pop();
            if(getPriority(first)<getPriority(second)){
                operators.push(second);
                operators.push(first);
                return;
            }
            else{
                String firstValue=(String)values.pop();
                String secondValue=(String)values.pop();
                values.push(getResults(secondValue, second, firstValue));
                operators.push(first);
            }
        }
    }

    public String getResults(String operand1, String operator, String operand2){
        try{
            double op1=Double.parseDouble(operand1);
            double op2=Double.parseDouble(operand2);
            if(operator.equals("*"))
                return ""+(op1*op2);
            else if(operator.equals("/"))
                return ""+(op1/op2);
            else if(operator.equals("+"))
                return ""+(op1+op2);
            else if(operator.equals("-"))
                return ""+(op1-op2);
            else
                return null;

        }
        catch(Exception e){
            return null;
        }
    }
}