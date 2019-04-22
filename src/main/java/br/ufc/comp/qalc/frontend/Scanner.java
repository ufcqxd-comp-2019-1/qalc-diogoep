package br.ufc.comp.qalc.frontend;

import br.ufc.comp.qalc.frontend.token.*;
import br.ufc.comp.qalc.frontend.token.Error;

import java.io.IOException;

/**
 * Analisador Léxico da linguagem.
 * <p>
 * Funciona como uma fonte de tokens, de onde o Analisador Sintático
 * deverá ler.
 *
 * @see Source
 */
public class Scanner {

    /**
     * Último token reconhecido.
     */
    protected Token currentToken;
    /**
     * Fonte de caracteres de onde extrair os tokens.
     */
    protected Source source;

    /**
     * Constrói um Analisador Léxico a partir de uma fonte de caracteres.
     *
     * @param sourceStream Fonte a ser utilizada.
     */
    public Scanner(Source sourceStream) {
        // FIXME Lidar corretamente com as exceções.
        this.source = sourceStream;
    }

    /**
     * Consome caracteres da fonte até que eles componham um lexema de
     * um dos tokens da linguagem, constrói um objeto representando esse
     * token associado ao lexema lido e o retorna.
     *
     * @return Token reconhecido.
     * @throws IOException Caso haja problema na leitura da fonte.
     */
    public Token getNextToken() throws IOException {
        if (source.getCurrentChar() == Source.EOF) {
            return new EOFToken(source.getCurrentLine(), source.getCurrentColumn());
        } else if (Character.isDigit(source.getCurrentChar())) {
            StringBuilder lexema = new StringBuilder();

            long currentLine = source.getCurrentLine();
            long lexemeStart = source.getCurrentColumn();

            do {
                lexema.append(source.getCurrentChar());
                source.advance();
            } while (Character.isDigit(source.getCurrentChar()));

            if(source.getCurrentChar() == '.'){
                lexema.append(source.getCurrentChar());
                source.advance();
                do {
                    lexema.append(source.getCurrentChar());
                    source.advance();
                } while(Character.isDigit(source.getCurrentChar()));
            }

            String stringValue = lexema.toString();

            return new NumberToken(currentLine, lexemeStart, stringValue);
        } else if (source.getCurrentChar() == '$') {
            source.advance();
            if ((Character.isDigit(source.getCurrentChar())) || (source.getCurrentChar() == '?')) {
                StringBuilder lexema = new StringBuilder();

                long currentLine = source.getCurrentLine();
                long lexemeStart = source.getCurrentColumn();

                do {
                    lexema.append(source.getCurrentChar());
                    source.advance();
                } while (Character.isDigit(source.getCurrentChar()) || (source.getCurrentChar() == '?'));
                String stringValue = lexema.toString();
                return new ResultIdentifierToken(currentLine, lexemeStart, stringValue);

            }else if (Character.isLetter(source.getCurrentChar())) {
                StringBuilder lexema = new StringBuilder();

                long currentLine = source.getCurrentLine();
                long lexemeStart = source.getCurrentColumn();

                do {
                    lexema.append(source.getCurrentChar());
                    source.advance();
                } while (Character.isLetter(source.getCurrentChar()));

                String stringValue = lexema.toString();

                return new VariableIdentifierToken(currentLine, lexemeStart, stringValue);
            }else{
                long currentLine = source.getCurrentLine();
                long lexemeStart = source.getCurrentColumn();
                source.advance();
                return new Error(currentLine, lexemeStart);
            }
        } else if (source.getCurrentChar() == '@') {
            StringBuilder lexema = new StringBuilder();

            long currentLine = source.getCurrentLine();
            long lexemeStart = source.getCurrentColumn();

            do {
                lexema.append(source.getCurrentChar());
                source.advance();
            } while ((Character.isDigit(source.getCurrentChar())) || (Character.isLetter(source.getCurrentChar())));
            String stringValue = lexema.toString();

            return new FunctionIdentifierToken(currentLine, lexemeStart, stringValue);
        } else if (source.getCurrentChar() == '=') {
            long currentLine = source.getCurrentLine();
            long lexemeStart = source.getCurrentColumn();
            source.advance();
            return new AtribToken(currentLine, lexemeStart);
        } else if (source.getCurrentChar() == '+') {
            long currentLine = source.getCurrentLine();
            long lexemeStart = source.getCurrentColumn();
            source.advance();
            return new PlusToken(currentLine, lexemeStart);
        } else if (source.getCurrentChar() == '-') {
            long currentLine = source.getCurrentLine();
            long lexemeStart = source.getCurrentColumn();
            source.advance();
            return new MinusToken(currentLine, lexemeStart);
        } else if (source.getCurrentChar() == '*') {
            long currentLine = source.getCurrentLine();
            long lexemeStart = source.getCurrentColumn();
            source.advance();
            return new TimesToken(currentLine, lexemeStart);
        } else if (source.getCurrentChar() == '/') {
            long currentLine = source.getCurrentLine();
            long lexemeStart = source.getCurrentColumn();
            source.advance();
            return new DivToken(currentLine, lexemeStart);
        } else if (source.getCurrentChar() == '%') {
            long currentLine = source.getCurrentLine();
            long lexemeStart = source.getCurrentColumn();
            source.advance();
            return new ModToken(currentLine, lexemeStart);
        } else if (source.getCurrentChar() == '^') {
            long currentLine = source.getCurrentLine();
            long lexemeStart = source.getCurrentColumn();
            source.advance();
            return new PowToken(currentLine, lexemeStart);
        } else if (source.getCurrentChar() == '(') {
            long currentLine = source.getCurrentLine();
            long lexemeStart = source.getCurrentColumn();
            source.advance();
            return new LParenToken(currentLine, lexemeStart);
        } else if (source.getCurrentChar() == ')') {
            long currentLine = source.getCurrentLine();
            long lexemeStart = source.getCurrentColumn();
            source.advance();
            return new RParenToken(currentLine, lexemeStart);
        } else if (source.getCurrentChar() == ',') {
            long currentLine = source.getCurrentLine();
            long lexemeStart = source.getCurrentColumn();
            source.advance();
            return new CommaToken(currentLine, lexemeStart);
        } else if (source.getCurrentChar() == ';') {
            long currentLine = source.getCurrentLine();
            long lexemeStart = source.getCurrentColumn();
            source.advance();
            return new SemiToken(currentLine, lexemeStart);
        } else if (source.getCurrentChar() == '\n') {
            long currentLine = source.getCurrentLine();
            long lexemeStart = source.getCurrentColumn();
            source.advance();
            return new BreakLineToken(currentLine, lexemeStart);
        } else if (source.getCurrentChar() == '#') {
            long currentLine = source.getCurrentLine();
            long lexemeStart = source.getCurrentColumn();
            do {
                source.advance();
            } while (source.getCurrentChar() != '/');
            return new CommentToken(currentLine, lexemeStart);
        } else if (source.getCurrentChar() == ' ') {
            long currentLine = source.getCurrentLine();
            long lexemaStart = source.getCurrentColumn();
            do{
                source.advance();
            }while (source.getCurrentChar() == ' ');
            return new SpaceToken(currentLine, lexemaStart);
        } else {
            long currentLine = source.getCurrentLine();
            long lexemeStart = source.getCurrentColumn();
            source.advance();
            return new Error(currentLine, lexemeStart);
        }

    }
    /**
     * Obtém o último token reconhecido.
     *
     * @return O último token reconhecido.
     */
    public Token getCurrentToken() {
        return currentToken;
    }
}
