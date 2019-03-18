
  CREATE TABLE "ISIS2304A211910"."SERVICIOCONSUMO" 
   (	"IDSERVICIO" NUMBER(*,0) NOT NULL ENABLE, 
	"IDPRODUCTO" NUMBER(*,0) NOT NULL ENABLE, 
	 CONSTRAINT "SERVICIOCONSUMO_PK" PRIMARY KEY ("IDSERVICIO", "IDPRODUCTO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 NOLOGGING 
  TABLESPACE "TBSPROD"  ENABLE, 
	 CONSTRAINT "IDSERVICIOCSERVICIOPROD_FK" FOREIGN KEY ("IDSERVICIO")
	  REFERENCES "ISIS2304A211910"."SERVICIO" ("ID") ENABLE, 
	 CONSTRAINT "IDCONSUMOSERVICIOPROD_FK" FOREIGN KEY ("IDPRODUCTO")
	  REFERENCES "ISIS2304A211910"."PRODUCTO" ("ID") ENABLE
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS NOLOGGING
  TABLESPACE "TBSPROD" ;
