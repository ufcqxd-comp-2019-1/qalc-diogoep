package br.ufc.comp.qalc.frontend.token;

public class LParenToken extends Token{
    public LParenToken(long line, long start){
        super(line, start, start);
    }

    @Override
    public String toString(){
        return "(";
    }

    @Override
    public String getTokenIdentifier(){
        return "%LPAREN%";
    }
}
