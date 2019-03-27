package br.ufc.comp.qalc.frontend.token;

public class MinusToken extends Token{
    public MinusToken(long line, long start){
        super(line, start, start);
    }

    @Override
    public String toString(){
        return "-";
    }

    @Override
    public String getTokenIdentifier(){
        return "%MINUS%";
    }
}
