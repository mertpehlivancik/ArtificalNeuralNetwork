CREATE DEFINER=`root`@`localhost` PROCEDURE `cellspancleanproc`()
BEGIN
DECLARE count INT Default 0;
      simple_loop: LOOP
         SET @a := count + 1;
         SET @b := (select person_oid from randomperson as r where r.person_id = @a);
         SET @statement = CONCAT('Create table cellspanclean2_',@b,' as select c.oid,c.endtime,c.starttime,c.person_oid,c.celltower_oid,c.dd,c.md,c.stime,c.duration,c.wdu from randomperson as r, cellspanclean2 as c where r.person_id = @a and r.person_oid = c.person_oid order by starttime;');
         PREPARE stmt FROM @statement;
                 EXECUTE stmt;
                 DEALLOCATE PREPARE stmt;
                 SET count = count + 1;
         IF count=20 THEN
            LEAVE simple_loop;
         END IF;
END LOOP simple_loop;
END