package fr.epsi.gostyle.services;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import fr.epsi.gostyle.model.Qrcode;

public class QrcodeServiceTest {
    
	@Test
	public void recuperationDUnQrcodeParSonId() {
		Integer id = 1;
		QrcodeService qrcodeService = Mockito.mock(QrcodeService.class);
	    Mockito.when(qrcodeService.find(1)).thenReturn(new Qrcode(1,"test",15));
	    
		Qrcode qrcode = qrcodeService.find(id);

		assertEquals(1,qrcode.getID());
		Mockito.verify(qrcodeService).find(1);
	}
	
	@Test
	public void tentativeRecuperationDUnQrcodeQuiNExistePas() {
		Integer id = 78;
		QrcodeService qrcodeService = Mockito.mock(QrcodeService.class);
	    Mockito.when(qrcodeService.find(1)).thenReturn(null);
	    
		Qrcode qrcode = qrcodeService.find(id);

		assertNull("hello there", qrcode);
		Mockito.verify(qrcodeService).find(78);
	}
	
}
