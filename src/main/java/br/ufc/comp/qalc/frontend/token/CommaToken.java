package br.ufc.comp.qalc.frontend.token;

public class CommaToken extends Token{
    public CommaToken(long line, long start){
        super(line, start, start);
    }

    @Override
    public String toString(){
        return ",";
    }

    @Override
    public String getTokenIdentifier(){
        return "COMMA";
    }
}
