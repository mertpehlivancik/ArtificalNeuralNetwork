CREATE DEFINER=`root`@`localhost` PROCEDURE `devicespancleanproc`()
BEGIN
DECLARE count INT Default 0;
      simple_loop: LOOP
         SET @a := count + 1;
         SET @b := (select person_oid from randomperson as r where r.person_id = @a);
         SET @statement = CONCAT('Create table devicespanclean2_',@b,' as select d.oid,d.endtime,d.starttime,d.person_oid,d.device_oid,d.duration,d.dd,d.md,d.stime,d.wdu from randomperson as r, devicespanclean2 as d where r.person_id = @a and r.person_oid = d.person_oid order by starttime;');
         PREPARE stmt FROM @statement;
                 EXECUTE stmt;
                 DEALLOCATE PREPARE stmt;
                 SET count = count + 1;
         IF count=20 THEN
            LEAVE simple_loop;
         END IF;
END LOOP simple_loop;
END