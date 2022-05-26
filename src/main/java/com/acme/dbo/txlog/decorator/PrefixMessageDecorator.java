package com.acme.dbo.txlog.decorator;

public class PrefixMessageDecorator {

    private static final String PRIMITIVE_PREFIX = "primitive";
    private static final String CHAR_PREFIX = "char";
    private static final String STRING_PREFIX = "string";
    private static final String REFERENCE_PREFIX = "reference";
    private static final String PRIMITIVES_ARRAY_PREFIX = "primitives array";
    private static final String PRIMITIVES_MATRIX_PREFIX = "primitives matrix";
    private static final String PRIMITIVE_MULTIMATRIX_PREFIX = "primitives multimatrix";


    public String decorateMessage(int message) {
        return PRIMITIVE_PREFIX + ": " + message;
    }

    public static String decorateMessage(byte message) {
        return PRIMITIVE_PREFIX + ": " + message;
    }

    public static String decorateMessage(char message) {
        return CHAR_PREFIX + ": " + message;
    }

    public String decorateMessage(String message) {
        return STRING_PREFIX + ": " + message;
    }

    public static String decorateMessage(boolean message) {
        return PRIMITIVE_PREFIX + ": " + message;
    }

    public static String decorateMessage(Object message) {
        return REFERENCE_PREFIX + ": " + message;
    }

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

}