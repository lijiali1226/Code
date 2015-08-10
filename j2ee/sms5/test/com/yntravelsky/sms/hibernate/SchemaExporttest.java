package com.yntravelsky.sms.hibernate;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;




public class SchemaExporttest {
	@Test
	public void testSchemaExport() {
		Configuration cfg=new Configuration().configure();
		SchemaExport s=new SchemaExport(cfg);
		s.create(true, true);
	}
}
