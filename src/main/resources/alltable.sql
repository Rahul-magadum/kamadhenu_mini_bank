CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    role ENUM('ADMIN','USER') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE customers (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    account_number VARCHAR(20) UNIQUE NOT NULL,
    name VARCHAR(100),
    dob DATE,
    address TEXT,
    id_proof VARCHAR(50),
    status ENUM('PENDING','APPROVED') DEFAULT 'PENDING',
    created_by INT,
    FOREIGN KEY (created_by) REFERENCES users(user_id)
);

CREATE TABLE transactions (
    txn_id INT AUTO_INCREMENT PRIMARY KEY,
    account_number VARCHAR(20),
    txn_type ENUM('DEPOSIT','WITHDRAWAL'),
    amount DECIMAL(12,2),
    balance_after DECIMAL(12,2),
    txn_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by INT,
    FOREIGN KEY (account_number) REFERENCES customers(account_number),
    FOREIGN KEY (created_by) REFERENCES users(user_id)
);

CREATE TABLE loans (
    loan_id INT AUTO_INCREMENT PRIMARY KEY,
    account_number VARCHAR(20),
    loan_type ENUM('FLAT','REDUCING'),
    principal DECIMAL(12,2),
    interest_rate DECIMAL(5,2),
    tenure_months INT,
    status ENUM('PENDING','APPROVED','DISBURSED','CLOSED') DEFAULT 'PENDING',
    emi_schedule JSON,
    FOREIGN KEY (account_number) REFERENCES customers(account_number)
);

CREATE TABLE fixed_deposits (
    fd_id INT AUTO_INCREMENT PRIMARY KEY,
    account_number VARCHAR(20),
    amount DECIMAL(12,2),
    interest_rate DECIMAL(5,2),
    tenure_months INT,
    maturity_amount DECIMAL(12,2),
    status ENUM('PENDING','APPROVED') DEFAULT 'PENDING',
    FOREIGN KEY (account_number) REFERENCES customers(account_number)
);

CREATE TABLE audit_logs (
    log_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    action VARCHAR(255),
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);
