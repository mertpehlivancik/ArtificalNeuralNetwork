CREATE DEFINER=`root`@`localhost` PROCEDURE `TrainMatlabData`()
BEGIN
DECLARE count INT Default 0;
DECLARE count2 INT Default 0;
	simple_loop: LOOP
		SET @a := count + 1;
		SET @b := (select person_oid from randomperson as r where r.person_id = @a);
		/*loop1*/
        
		/*loop1*/
		simple_loop2: LOOP
			SET @c := count2 + 1;
			/*loop2*/
			
            SET @statement = CONCAT('SELECT * FROM devicespanclean2_',@b,'t_all_',@c,' INTO OUTFILE \'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/device',@b,'all',@c,'t.data\' FIELDS TERMINATED BY \'\t\' OPTIONALLY ENCLOSED BY \'\' LINES TERMINATED BY \'\n\';');
			PREPARE stmt FROM @statement;
                 EXECUTE stmt;
                 DEALLOCATE PREPARE stmt;
                 
            SET @statement2 = CONCAT('SELECT * FROM devicespanclean2_',@b,'t_a_',@c,' INTO OUTFILE \'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/device',@b,'a',@c,'t.data\' FIELDS TERMINATED BY \'\t\' OPTIONALLY ENCLOSED BY \'\' LINES TERMINATED BY \'\n\';');
			PREPARE stmt2 FROM @statement2;
                 EXECUTE stmt2;
                 DEALLOCATE PREPARE stmt2;
                 
            SET @statement3 = CONCAT('SELECT * FROM devicespanclean2_',@b,'t_b_',@c,' INTO OUTFILE \'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/device',@b,'b',@c,'t.data\' FIELDS TERMINATED BY \'\t\' OPTIONALLY ENCLOSED BY \'\' LINES TERMINATED BY \'\n\';');
			PREPARE stmt3 FROM @statement3;
                 EXECUTE stmt3;
                 DEALLOCATE PREPARE stmt3;     
            
            SET @statement4 = CONCAT('SELECT * FROM devicespanclean2_',@b,'t_c_',@c,' INTO OUTFILE \'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/device',@b,'c',@c,'t.data\' FIELDS TERMINATED BY \'\t\' OPTIONALLY ENCLOSED BY \'\' LINES TERMINATED BY \'\n\';');
			PREPARE stmt4 FROM @statement4;
                 EXECUTE stmt4;
                 DEALLOCATE PREPARE stmt4;
                 
			SET @statement5 = CONCAT('SELECT * FROM cellspanclean2_',@b,'t_all_',@c,' INTO OUTFILE \'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/cell',@b,'all',@c,'t.data\' FIELDS TERMINATED BY \'\t\' OPTIONALLY ENCLOSED BY \'\' LINES TERMINATED BY \'\n\';');
			PREPARE stmt5 FROM @statement5;
                 EXECUTE stmt5;
                 DEALLOCATE PREPARE stmt5;
                 
            SET @statement6 = CONCAT('SELECT * FROM cellspanclean2_',@b,'t_a_',@c,' INTO OUTFILE \'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/cell',@b,'a',@c,'t.data\' FIELDS TERMINATED BY \'\t\' OPTIONALLY ENCLOSED BY \'\' LINES TERMINATED BY \'\n\';');
			PREPARE stmt6 FROM @statement6;
                 EXECUTE stmt6;
                 DEALLOCATE PREPARE stmt6;
                 
            SET @statement7 = CONCAT('SELECT * FROM cellspanclean2_',@b,'t_b_',@c,' INTO OUTFILE \'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/cell',@b,'b',@c,'t.data\' FIELDS TERMINATED BY \'\t\' OPTIONALLY ENCLOSED BY \'\' LINES TERMINATED BY \'\n\';');
			PREPARE stmt7 FROM @statement7;
                 EXECUTE stmt7;
                 DEALLOCATE PREPARE stmt7;     
            
            SET @statement8 = CONCAT('SELECT * FROM cellspanclean2_',@b,'t_c_',@c,' INTO OUTFILE \'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/cell',@b,'c',@c,'t.data\' FIELDS TERMINATED BY \'\t\' OPTIONALLY ENCLOSED BY \'\' LINES TERMINATED BY \'\n\';');
			PREPARE stmt8 FROM @statement8;
                 EXECUTE stmt8;
                 DEALLOCATE PREPARE stmt8;
                 
            SET @statement9 = CONCAT('SELECT * FROM callspanclean3_',@b,'t_all_',@c,' INTO OUTFILE \'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/call',@b,'all',@c,'t.data\' FIELDS TERMINATED BY \'\t\' OPTIONALLY ENCLOSED BY \'\' LINES TERMINATED BY \'\n\';');
			PREPARE stmt9 FROM @statement9;
                 EXECUTE stmt9;
                 DEALLOCATE PREPARE stmt9;
                 
            SET @statement10 = CONCAT('SELECT * FROM callspanclean3_',@b,'t_a_',@c,' INTO OUTFILE \'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/call',@b,'a',@c,'t.data\' FIELDS TERMINATED BY \'\t\' OPTIONALLY ENCLOSED BY \'\' LINES TERMINATED BY \'\n\';');
			PREPARE stmt10 FROM @statement10;
                 EXECUTE stmt10;
                 DEALLOCATE PREPARE stmt10;
                 
            SET @statement11 = CONCAT('SELECT * FROM callspanclean3_',@b,'t_b_',@c,' INTO OUTFILE \'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/call',@b,'b',@c,'t.data\' FIELDS TERMINATED BY \'\t\' OPTIONALLY ENCLOSED BY \'\' LINES TERMINATED BY \'\n\';');
			PREPARE stmt11 FROM @statement11;
                 EXECUTE stmt11;
                 DEALLOCATE PREPARE stmt11;     
            
            SET @statement12 = CONCAT('SELECT * FROM callspanclean3_',@b,'t_c_',@c,' INTO OUTFILE \'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/call',@b,'c',@c,'t.data\' FIELDS TERMINATED BY \'\t\' OPTIONALLY ENCLOSED BY \'\' LINES TERMINATED BY \'\n\';');
			PREPARE stmt12 FROM @statement12;
                 EXECUTE stmt12;
                 DEALLOCATE PREPARE stmt12; 
                 
			SET @statement13 = CONCAT('SELECT * FROM callspanclean3_',@b,'t_d_',@c,' INTO OUTFILE \'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/call',@b,'d',@c,'t.data\' FIELDS TERMINATED BY \'\t\' OPTIONALLY ENCLOSED BY \'\' LINES TERMINATED BY \'\n\';');
			PREPARE stmt13 FROM @statement13;
                 EXECUTE stmt13;
                 DEALLOCATE PREPARE stmt13;     
            
            SET @statement14 = CONCAT('SELECT * FROM callspanclean3_',@b,'t_e_',@c,' INTO OUTFILE \'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/call',@b,'e',@c,'t.data\' FIELDS TERMINATED BY \'\t\' OPTIONALLY ENCLOSED BY \'\' LINES TERMINATED BY \'\n\';');
			PREPARE stmt14 FROM @statement14;
                 EXECUTE stmt14;
                 DEALLOCATE PREPARE stmt14;
            
            SET @statement15 = CONCAT('SELECT * FROM activityspanclean2_',@b,'t_all_',@c,' INTO OUTFILE \'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/act',@b,'all',@c,'t.data\' FIELDS TERMINATED BY \'\t\' OPTIONALLY ENCLOSED BY \'\' LINES TERMINATED BY \'\n\';');
			PREPARE stmt15 FROM @statement15;
                 EXECUTE stmt15;
                 DEALLOCATE PREPARE stmt15;     
            
            SET @statement16 = CONCAT('SELECT * FROM activityspanclean2_',@b,'t_a_',@c,' INTO OUTFILE \'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/act',@b,'a',@c,'t.data\' FIELDS TERMINATED BY \'\t\' OPTIONALLY ENCLOSED BY \'\' LINES TERMINATED BY \'\n\';');
			PREPARE stmt16 FROM @statement16;
                 EXECUTE stmt16;
                 DEALLOCATE PREPARE stmt16; 
                 
			SET @statement17 = CONCAT('SELECT * FROM activityspanclean2_',@b,'t_b_',@c,' INTO OUTFILE \'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/act',@b,'b',@c,'t.data\' FIELDS TERMINATED BY \'\t\' OPTIONALLY ENCLOSED BY \'\' LINES TERMINATED BY \'\n\';');
			PREPARE stmt17 FROM @statement17;
                 EXECUTE stmt17;
                 DEALLOCATE PREPARE stmt17;     
            
            SET @statement18 = CONCAT('SELECT * FROM activityspanclean2_',@b,'t_c_',@c,' INTO OUTFILE \'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/act',@b,'c',@c,'t.data\' FIELDS TERMINATED BY \'\t\' OPTIONALLY ENCLOSED BY \'\' LINES TERMINATED BY \'\n\';');
			PREPARE stmt18 FROM @statement18;
                 EXECUTE stmt18;
                 DEALLOCATE PREPARE stmt18;
			/*loop2*/
			SET count2 = count2 +1;
				IF count2=10 THEN
					SET count2 := count2 - 10;
					SET @c := count2 + 0;
					LEAVE simple_loop2;
				END IF;
		END LOOP simple_loop2;  
      
		SET count = count + 1;
			IF count=20 THEN
              LEAVE simple_loop;
			END IF; 
	END LOOP simple_loop;
END