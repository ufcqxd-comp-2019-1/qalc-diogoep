package br.ufc.comp.qalc.frontend.token;

public class AtribToken extends Token{
    public AtribToken(long line, long start){
        super(line, start, start);
    }

    @Override
    public String toString(){
        return "=";
    }

    @Override
    public String getTokenIdentifier(){
        return "%ATRIB%";
    }
}
