package br.ufc.comp.qalc.frontend.token;

public class PowToken extends Token{
    public PowToken(long line, long start){
        super(line, start, start);
    }

    @Override
    public String toString(){
        return "^";
    }

    @Override
    public String getTokenIdentifier(){
        return "POW";
    }
}
