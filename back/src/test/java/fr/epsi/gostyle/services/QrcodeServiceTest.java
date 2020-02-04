package fr.epsi.gostyle.services;

import static org.junit.Assert.*;

import org.junit.Test;
import fr.epsi.gostyle.model.Qrcode;

public class QrcodeServiceTest {
    QrcodeService qrcodeService;
    
	@Test
	public void recuperationDUnQrcodeParSonId() {
		Integer id = 0;
		
		Qrcode qrcode = qrcodeService.find(id);

		assertEquals(0,qrcode.getID());
	}
}
