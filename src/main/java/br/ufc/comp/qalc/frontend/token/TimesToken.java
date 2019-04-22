package br.ufc.comp.qalc.frontend.token;

public class TimesToken extends Token{
    public TimesToken(long line, long start){
        super(line, start, start);
    }

    @Override
    public String toString(){
        return "*";
    }

    @Override
    public String getTokenIdentifier(){
        return "TIMES";
    }
}
