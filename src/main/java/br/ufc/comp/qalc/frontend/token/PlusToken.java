package br.ufc.comp.qalc.frontend.token;

public class PlusToken extends Token{
    public PlusToken(long line, long start){
        super(line, start, start);
    }

    @Override
    public String toString(){
        return "+";
    }

    @Override
    public String getTokenIdentifier(){
        return "%PLUS%";
    }
}
