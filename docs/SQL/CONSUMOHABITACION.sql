  CREATE TABLE "ISIS2304A211910"."CONSUMOHABITACION" 
   (	"ID" NUMBER(*,0) NOT NULL ENABLE, 
	"VALORTOTAL" NUMBER NOT NULL ENABLE, 
	"IDHABITACION" NUMBER(*,0), 
	 CONSTRAINT "CONSUMOPORHABITACION_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 NOLOGGING 
  TABLESPACE "TBSPROD"  ENABLE, 
	 CONSTRAINT "CARACTERISTICASCONSUMOHAB_CK" CHECK (valorTotal>=0) ENABLE, 
	 CONSTRAINT "IDHABCONSUMOHAB_FK" FOREIGN KEY ("IDHABITACION")
	  REFERENCES "ISIS2304A211910"."HABITACION" ("ID") ENABLE
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS NOLOGGING
  TABLESPACE "TBSPROD" ;
