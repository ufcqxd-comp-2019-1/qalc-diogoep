package br.ufc.comp.qalc.frontend.token;

public class RParenToken extends Token{
    public RParenToken(long line, long start){
        super(line, start, start);
    }

    @Override
    public String toString(){
        return ")";
    }

    @Override
    public String getTokenIdentifier(){
        return "RPAREN";
    }
}
