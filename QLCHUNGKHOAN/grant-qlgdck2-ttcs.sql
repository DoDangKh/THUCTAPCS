Use QLGDCK2
create role NHANVIEN
GRANT SELECT ,UPDATE ,DELETE ,INSERT on SCHEMA :: [dbo] to NHANVIEN
DENY SELECT ,UPDATE ,DELETE, INSERT on [dbo].NHANVIEN to NHANVIEN
DENY SELECT ,UPDATE ,DELETE, INSERT on [dbo].TAIKHOAN to NHANVIEN

Create Login NV07 with password='123456'

Create Login NV02 with password='123456'

Create user NV01 for login NV07

Exec Sp_addRoleMember 'NHANVIEN' , 'NV01'

Create user NV02 for login NV02

Exec sp_addrolemember 'NHANVIEN','NV02'

Use QLGDCK2
create role ADMIN

GRANT ALTER,DELETE,EXECUTE, INSERT ,SELECT on SCHEMA::[dbo] to ADMIN
Exec sp_addrolemember 'db_owner','ADMIN'

Exec sp_addrolemember 'db_securityadmin', 'ADMIN'

CREATE LOGIN AD01 with password='123456'

Use QLGDCK2
CREATE USER AD01 for login AD01

ALTER SERVER ROLE [securityadmin] ADD MEMBER [AD01]

Exec sp_addrolemember 'ADMIN','AD01'