package com.acme.dbo.txlog.decorator;

import com.acme.dbo.txlog.domain.Message;

public abstract class PrefixMessageDecorator implements Message {
    private final String prefix;

    protected PrefixMessageDecorator(String prefix){
        this.prefix = prefix;
    }

    protected String decorate(String body){
        return prefix + body;
    }

    /*

    public static String decorateMessage(int[] message) {
        String arrayContain = decorateRaw(message);
        return PRIMITIVES_ARRAY_PREFIX + ": " + arrayContain;
    }

    public static String decorateMessage(int[][] message) {
        String matrixContain = "{" + System.lineSeparator();
        for (int[] matrixElement:message) {
            matrixContain = matrixContain + decorateRaw(matrixElement);
            matrixContain = matrixContain + System.lineSeparator();
        }
        matrixContain = matrixContain + "}";
        return PRIMITIVES_MATRIX_PREFIX + ": " + matrixContain;
    }

    public static String decorateMessage(int[][][][] message) {
        String matrixContain = "{" + System.lineSeparator();
        for (int[][][] matrixElement:message) {
            matrixContain = matrixContain + "{" + System.lineSeparator();
            for (int[][] matrixElementInternal:matrixElement) {
                matrixContain = matrixContain + "{" + System.lineSeparator();
                for (int[] matrixElementInternalCore:matrixElementInternal) {
                    matrixContain = matrixContain + "{" + System.lineSeparator();
                    for (int matrixElementCore: matrixElementInternalCore) {
                        matrixContain = matrixContain + matrixElementCore + System.lineSeparator() + "}";
                    }
                    matrixContain = matrixContain + System.lineSeparator();
                }
                matrixContain = matrixContain + "}" + System.lineSeparator();
            }
            matrixContain = matrixContain + "}" + System.lineSeparator();
        }
        matrixContain = matrixContain + "}";
        return PRIMITIVE_MULTIMATRIX_PREFIX + ": " + matrixContain;
    }

    private static String decorateRaw(int[] message) {
        String arrayContain = "{";
        for (int element:message) {
            arrayContain = arrayContain + element + ", ";
        }
        arrayContain = arrayContain.substring(0 ,arrayContain.length() - 2) + "}";
        return arrayContain;
    }

    public static String decorateMessage(String... message) {
        String arrayString = new String();
        for (String messageElement: message) {
            arrayString = arrayString + messageElement + System.lineSeparator();
        }
        arrayString = arrayString.substring(0, arrayString.length() - 1);
        return arrayString;
    }

    public static String decorateMessage(Integer... message) {
        Integer sum = 0;
        for (Integer arrayElement:message) {
            sum = sum + arrayElement;
        }
        return String.valueOf(sum);
    }

     */

}