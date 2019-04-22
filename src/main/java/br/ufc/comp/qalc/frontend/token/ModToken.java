package br.ufc.comp.qalc.frontend.token;

public class ModToken extends Token{
    public ModToken(long line, long start){
        super(line, start, start);
    }

    @Override
    public String toString(){
        return "%";
    }

    @Override
    public String getTokenIdentifier(){
        return "MOD";
    }
}
