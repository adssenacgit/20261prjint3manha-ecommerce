package br.senac.prjint3.model;

public final class StatusRegistro {

    public static final int APAGADO = -1;
    public static final int INATIVO = 0;
    public static final int ATIVO = 1;

    private StatusRegistro() {
    }

    public static boolean isValido(Integer status) {
        return status != null && (status == APAGADO || status == INATIVO || status == ATIVO);
    }
}
