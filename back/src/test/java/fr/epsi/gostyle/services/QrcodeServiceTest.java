package fr.epsi.gostyle.services;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;
import fr.epsi.gostyle.model.Qrcode;
import fr.epsi.gostyle.model.exception.QrcodeNotFoundException;

public class QrcodeServiceTest {
    
	@Test
	public void recuperationDUnQrcodeParSonId() throws Exception {
		Integer id = 1;
		QrcodeService qrcodeService = Mockito.mock(QrcodeService.class);
	    Mockito.when(qrcodeService.find(1)).thenReturn(new Qrcode(1,"test",15));
	    
		Qrcode qrcode = qrcodeService.find(id);

		assertEquals(1,qrcode.getID());
		Mockito.verify(qrcodeService).find(1);
	}
	
	@Test(expected= QrcodeNotFoundException.class)
	public void tentativeRecuperationDUnQrcodeQuiNExistePas() throws QrcodeNotFoundException {
		Integer id = 78;
		QrcodeService qrcodeService = Mockito.mock(QrcodeService.class);
	    Mockito.when(qrcodeService.find(78)).thenThrow(QrcodeNotFoundException.class);
	    
		Qrcode qrcode = qrcodeService.find(id);

		fail("QrcodeNotFoundException expected");
	}
	
}
