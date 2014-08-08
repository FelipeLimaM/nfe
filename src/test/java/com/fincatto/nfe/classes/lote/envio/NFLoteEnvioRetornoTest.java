package com.fincatto.nfe.classes.lote.envio;

import org.joda.time.LocalDateTime;
import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe.FabricaDeObjetosFake;
import com.fincatto.nfe.classes.NFAmbiente;
import com.fincatto.nfe.classes.NFUnidadeFederativa;

public class NFLoteEnvioRetornoTest {

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFLoteEnvioRetorno retorno = new NFLoteEnvioRetorno();
        retorno.setAmbiente(NFAmbiente.HOMOLOGACAO);
        retorno.setDataRecebimento(new LocalDateTime(2014, 1, 1, 10, 10, 10));
        retorno.setInfoRecebimento(FabricaDeObjetosFake.getNFLoteEnvioRetornoRecebimentoInfo());
        retorno.setMotivo("kdosfksodf");
        retorno.setStatus("iejsasfisf");
        retorno.setUf(NFUnidadeFederativa.BA);
        retorno.setVersao("2.00");
        retorno.setVersaoAplicacao("2.00");

        final String xmlEsperado = "<retEnviNFe versao=\"2.00\"><tpAmb>2</tpAmb><verAplic>2.00</verAplic><cStat>iejsasfisf</cStat><xMotivo>kdosfksodf</xMotivo><cUF>29</cUF><dhRecbto>2014-01-01T10:10:10</dhRecbto><infRec><nRec>845e40545</nRec><tMed>430kfszodkgvre</tMed></infRec></retEnviNFe>";
        Assert.assertEquals(xmlEsperado, retorno.toString());
    }
}