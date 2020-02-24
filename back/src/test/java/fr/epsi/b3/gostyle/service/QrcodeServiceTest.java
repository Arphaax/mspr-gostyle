package fr.epsi.b3.gostyle.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;
import fr.epsi.b3.gostyle.model.Qrcode;
import fr.epsi.b3.gostyle.exception.QrcodeNotFoundException;

public class QrcodeServiceTest {

	@Test
	public void recuperationDUnQrcodeParSonId() throws Exception {
		Integer id = 1;
		QrcodeService qrcodeService = Mockito.mock(QrcodeService.class);
		Qrcode qrcode = new Qrcode();
		qrcode.setLibelle("test");
		qrcode.setMontant(15);
	    Mockito.when(qrcodeService.findById(1)).thenReturn(qrcode);

		Qrcode result = qrcodeService.findById(id);

		assertEquals(1,result.getID());
		Mockito.verify(qrcodeService).findById(1);
	}

	@Test(expected= QrcodeNotFoundException.class)
	public void tentativeRecuperationDUnQrcodeQuiNExistePas() throws QrcodeNotFoundException {
		Integer id = 78;
		QrcodeService qrcodeService = Mockito.mock(QrcodeService.class);
	    Mockito.when(qrcodeService.findById(78)).thenThrow(QrcodeNotFoundException.class);

		Qrcode qrcode = qrcodeService.findById(id);

		fail("QrcodeNotFoundException expected");
	}

}
