CREATE DEFINER=`root`@`localhost` PROCEDURE `callspancleanproc`()
BEGIN
DECLARE count INT Default 0;
      simple_loop: LOOP
         SET @a := count + 1;
         SET @b := (select person_oid from randomperson as r where r.person_id = @a);
         SET @statement = CONCAT('Create table callspanclean3_',@b,' as select c.oid,c.endtime,c.starttime,c.person_oid,c.phonenumber_oid,c.duration,c.dd,c.md,c.stime,c.wdu,c.cidu,c.descid,c.dirid from randomperson as r, callspanclean3 as c where r.person_id = 1 and r.person_oid = c.person_oid order by starttime;');
         PREPARE stmt FROM @statement;
                 EXECUTE stmt;
                 DEALLOCATE PREPARE stmt;
                 SET count = count + 1;
         IF count=20 THEN
            LEAVE simple_loop;
         END IF;
END LOOP simple_loop;
END