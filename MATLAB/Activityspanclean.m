%Mert Pehlivancik
%Activity Som Images


char={'all','a','b','c'}; % define string for cellspan column 
% There are 5 sets for each user
user_count={'1','2','3','4','5','6','7','8','9','10'}; % define string for cellspan's user sets
% user numbers which using for test and training
user_no = {'10','12','96','81','83','41','80','92','73','29','34','84','44','69','13','77','15','75','65','27'}; 


%Train & test starts
% There are 3 for loop for take .data files from directory

for index=1:length(user_no) 
for index2=1:length(char) 
for index3=1:length(user_count)

% define .data extension file from directory
sD=som_read_data(strcat('act',user_no{index},char{index2},user_count{index3},'t','.data'));

% There are three if condition for determine log & logistic values

if char{index2}=='all'
sD=som_normalize(sD,'log',[1 2 4 5]); % for greater than 10
sD=som_normalize(sD,'logistic',[3]); % for less than 10
end
if char{index2}=='a'
sD=som_normalize(sD,'log',[1 3 4]); % for greater than 10
sD=som_normalize(sD,'logistic',[2]); % for less than 10
end
if char{index2}=='b'
sD=som_normalize(sD,'log',[1 3 4]); 
sD=som_normalize(sD,'logistic',[2]);
end
if char{index2}=='c'
sD=som_normalize(sD,'log',[2 3]); 
sD=som_normalize(sD,'logistic',[1]);
end

sM=som_make(sD);
sM=som_autolabel(sM,sD,'vote');
som_show(sM,'empty','Train','empty','Test');
htrain1=som_hits(sM,sD); % SD.data

%There are 900 instance 450 Yes and 450 No, seperate values each other with h1 and h2
h1 = som_hits(sM,sD.data(1:475,:)); 
h2 = som_hits(sM,sD.data(476:950,:));

som_show_add('hit',[h1],'MarkerColor','b','Subplot',1);
som_show_add('hit',[h2],'MarkerColor','g','Subplot',1);
som_show_add('label',sM,'Textsize',8,'TextColor','r','Subplot',1);

bmusTrain = som_bmus(sM, sD); % hangi instance haritada hangi kordinate denk geldiðini bulmak için
    
                    %test kýsmýna gectik
    
sDt=som_read_data(strcat('act',user_no{index},char{index2},'tt','.data'));

if char{index2}=='all'
sDt=som_normalize(sDt,'log',[1 2 4 5]); % for greater than 10
sDt=som_normalize(sDt,'logistic',[3]); % for less than 10
end
if char{index2}=='a'
sDt=som_normalize(sDt,'log',[1 3 4]); % for greater than 10
sDt=som_normalize(sDt,'logistic',[2]); % for less than 10
end
if char{index2}=='b'
sDt=som_normalize(sDt,'log',[1 3 4]); 
sDt=som_normalize(sDt,'logistic',[2]);
end
if char{index2}=='c'
sDt=som_normalize(sDt,'log',[2 3]); 
sDt=som_normalize(sDt,'logistic',[1]);
end

htest1=som_hits(sM,sDt);

h3 = som_hits(sM,sDt.data(1:100,:)); %1 den 200 evetler
h4 = som_hits(sM,sDt.data(101:2000,:)); % 201 den 2000 e hayýrlar

som_show_add('hit',[h3],'MarkerColor','r','Subplot',2);
som_show_add('hit',[h4],'MarkerColor','y','Subplot',2)
som_show_add('label',sM,'Textsize',8,'TextColor','b','Subplot',2);

bmusTest = som_bmus(sM, sDt); % hangi instance haritada hangi kordinate denk geldiðini bulmak için

% save obtained image to directory than close it.
% bu iþlem tüm resimleri çýkarýncaya kadar devam eder

saveas(gcf,strcat('act',user_no{index},user_count{index3},char{index2}),'jpg');
close
end
end
end