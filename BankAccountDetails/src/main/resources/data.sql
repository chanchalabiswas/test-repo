INSERT INTO USER (user_name) VALUES ("TOM");
INSERT INTO USER (user_name) VALUES ("PAUL");
INSERT INTO USER (user_name) VALUES ("KHEN");
INSERT INTO USER (user_name) VALUES ("CHRIS");

INSERT INTO ACCOUNT(acc_number, acc_name, acc_type, bal_date, currency, avail_balance, user_id) VALUES ('585309209','SGSavings726','Savings', '2018-11-08', 'SGD', 84327.5167, 1);
INSERT INTO ACCOUNT(acc_number, acc_name, acc_type, bal_date, currency, avail_balance, user_id) VALUES ('791066619','AUSavings933','Savings', '2018-11-08', 'AUD', 88005.9334, 1);
INSERT INTO ACCOUNT(acc_number, acc_name, acc_type, bal_date, currency, avail_balance, user_id) VALUES ('321143048','AUCurrent433','Current', '2018-11-08', 'SGD', 38010.624, 1);  
INSERT INTO ACCOUNT(acc_number, acc_name, acc_type, bal_date, currency, avail_balance, user_id) VALUES ('584879207','SGSavings207','Savings', '2018-11-08', 'SGD', 84827.51, 2);
INSERT INTO ACCOUNT(acc_number, acc_name, acc_type, bal_date, currency, avail_balance, user_id) VALUES ('894066465','AUSavings465','Savings', '2018-11-08', 'AUD', 88905.936, 2);
INSERT INTO ACCOUNT(acc_number, acc_name, acc_type, bal_date, currency, avail_balance, user_id) VALUES ('321163048','AUCurrent448','Current', '2018-11-08', 'SGD', 38110.6287, 3);  

INSERT INTO TRANSACTION(value_dt,credit_amount,trans_type,account_id) VALUES('2012-01-12', 9540.983, 'Credit', 1);     
INSERT INTO TRANSACTION(value_dt,credit_amount,trans_type,account_id) VALUES('2012-01-12', 7497.829, 'Credit', 1);  
INSERT INTO TRANSACTION(value_dt,credit_amount,trans_type,NARRATIVE, account_id) VALUES('2012-01-12', 5564.79, 'Credit', 'Flipkart', 1);    
INSERT INTO TRANSACTION(value_dt,debit_amount,trans_type,NARRATIVE,account_id) VALUES('2012-01-12', 1176.98, 'Debit', 'Debit via ATM', 2);    
INSERT INTO TRANSACTION(value_dt,credit_amount,trans_type,account_id) VALUES('2012-01-12', 74.8245, 'Credit', 2); 
INSERT INTO TRANSACTION(value_dt,credit_amount,trans_type,account_id) VALUES('2012-01-12', 97.82, 'Credit', 3); 
INSERT INTO TRANSACTION(value_dt,debit_amount,trans_type,NARRATIVE,account_id) VALUES('2012-01-12', 76.98, 'Debit', 'Cheque', 4);                                             