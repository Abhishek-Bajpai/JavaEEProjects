CREATE TABLE bank.customerinfo 
(
fullname varchar2(60),
dateofbirth DATE, 
emailid varchar2(25) PRIMARY key,
address varchar2(150), 
password varchar2(90)
);


CREATE TABLE bank.accountinfo 
(
accnumber NUMBER PRIMARY KEY ,
acctype varchar2(20), 
emailid varchar2(25),CONSTRAINT  FK_customerEmailLogin FOREIGN KEY(emailid) REFERENCES  bank.customerinfo(emailid),
currentbal NUMBER
);

CREATE TABLE bank.transactioninfo 
(
txnid number,
accnumber NUMBER, 
CONSTRAINT  FK_accnofortxnlog FOREIGN KEY(accnumber) REFERENCES bank.accountinfo(accnumber),
datetimeofoperation DATE,
amountinvolved NUMBER,
typeofoperation varchar2(10)
);



