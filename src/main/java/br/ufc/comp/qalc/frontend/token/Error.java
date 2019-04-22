package br.ufc.comp.qalc.frontend.token;

/**
 * Token representando o fim do fluxo de tokens, que deve coincidir
 * com o fim do fluxo de entrada.
 */
public class Error extends Token {
    public Error(long line, long start){
        super(line, start, start);
    }

    @Override
    public String toString(){
        // NOTE: Não existe lexema associado, porém é o único token que não possui
        return "ERRO";
    }

    @Override
    public String getTokenIdentifier(){
        return "ERRO";
    }
}
