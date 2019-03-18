package br.ufc.comp.qalc.frontend.token;

public class SemiToken extends Token{
    public SemiToken(long line, long start){
        super(line, start, start);
    }

    @Override
    public String toString(){
        return ";";
    }

    @Override
    public String getTokenIdentifier(){
        return "%;%";
    }
}
