CREATE DEFINER=`root`@`localhost` PROCEDURE `activityspancleanproc`()
BEGIN
DECLARE count INT Default 0;
      simple_loop: LOOP
         SET @a := count + 1;
         SET @b := (select person_oid from randomperson as r where r.person_id = @a);
         SET @statement = CONCAT('Create table activityspanclean2_',@b,' as select a.oid,a.endtime,a.starttime,a.person_oid,a.duration,a.dd,a.md,a.stime,a.wdu from randomperson as r, activityspanclean2 as a where r.person_id = @a and r.person_oid = a.person_oid order by starttime;');
         PREPARE stmt FROM @statement;
                 EXECUTE stmt;
                 DEALLOCATE PREPARE stmt;
                 SET count = count + 1;
         IF count=20 THEN
            LEAVE simple_loop;
         END IF;
END LOOP simple_loop;
END