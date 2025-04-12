# StoreHouseServer

Base de datos utilizada:

DROP DATABASE IF EXISTS Store;
CREATE DATABASE Store;
USE Store;

-- Tabla de Usuarios
CREATE TABLE users (
    user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    mail VARCHAR(30) UNIQUE, -- Solo NOT NULL para administradores
    image VARCHAR(30),
    pass VARCHAR(30), -- Solo NOT NULL para administradores ***Tendré que cambiarlo a Hash, no se puede guardar directamente en texto plano
    rol ENUM('USUARIO', 'ADMINISTRADOR') NOT NULL, -- No boolean porque pueden ser agregados más roles en un futuro
    enabled BOOLEAN DEFAULT TRUE -- TRUE = habilitado, FALSE = deshabilitado, sirve para rechazar usuarios deshabilitados en la API REST
);

-- Tabla de Productosinvoices
CREATE TABLE products (
    product_id BIGINT AUTO_INCREMENT PRIMARY KEY, -- Tiene que ser AUTO_INCREMENT
    image VARCHAR(30),		-- Se guardará la URL de cada imagen, las img se guardan en el servidor 
    name VARCHAR(30) NOT NULL UNIQUE,
    amount INT NOT NULL DEFAULT 0,  -- Stock actual
    minimum_amount INT DEFAULT 0,  -- Límite mínimo antes de alertar
    season BOOLEAN DEFAULT TRUE,  -- Producto de temporada
    enabled BOOLEAN DEFAULT TRUE,  -- Si está activo o no
    price DECIMAL(10, 2) NOT NULL DEFAULT 0.00,  -- Precio del producto
    sell_price DECIMAL(10,2) DEFAULT 0
);

-- Tabla de Albaranes (Compras/Entradas de Productos)
CREATE TABLE invoices (
    invoice_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    CIF VARCHAR(9) NOT NULL, -- No es UNIQUE ya que una empresa puede emitir varias facturas 
    date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,  -- Fecha del albarán
    total DECIMAL(10,2) DEFAULT 0,  -- Total de la compra
    paid BOOLEAN NOT NULL DEFAULT FALSE,  -- Pagado o no
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

-- Tabla de Detalles del Albarán
CREATE TABLE product_invoice (
    detail_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    invoice_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    quantity INT NOT NULL CHECK (quantity > 0),  -- No puede ser 0 o negativo
    unit_price DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (invoice_id) REFERENCES invoices(invoice_id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES products(product_id) ON DELETE CASCADE
);

 -- Tabla de la venta
CREATE TABLE sales (
	sale_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    product_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    total DECIMAL(10, 2) NOT NULL,  -- Total de la venta (se puede calcular automáticamente si se guarda por separado)
    date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,  -- Fecha de la venta
    FOREIGN KEY (product_id) REFERENCES products(product_id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

CREATE TABLE details_sale (
    detail_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    sale_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    quantity INT NOT NULL CHECK (quantity > 0),
    unit_price DECIMAL(10, 2) NOT NULL,  -- Precio por unidad del producto en el momento de la venta
    FOREIGN KEY (sale_id) REFERENCES sales(sale_id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES products(product_id) ON DELETE CASCADE
);

INSERT INTO users (name, mail, pass, rol, enabled) VALUES
('Admin1', 'admin1@example.com', ('pass666'), 'ADMINISTRADOR', TRUE), 
('Admin2', 'admin2@example.com', ('pass999'), 'ADMINISTRADOR', TRUE), -- ('Admin2', 'admin2@example.com', SHA2('pass999', 256), 'ADMINISTRADOR', TRUE),
('Empleado1', NULL, NULL, 'USUARIO', TRUE),
('Empleado2', NULL, NULL, 'USUARIO', FALSE);

INSERT INTO products (image, name, amount, minimum_amount, season, enabled, price) VALUES
(NULL, 'Botella de agua', 50, 10, TRUE, TRUE, 0.80),
(NULL, 'Monster', 30, 5, TRUE, TRUE, 1.20),
(NULL, 'Cerveza', 15, 5, FALSE, TRUE, 2.50),
(NULL, 'Cajas de galletas', 40, 10, TRUE, FALSE, 1.75);

INSERT INTO products (image, name, amount, minimum_amount, season, enabled, price) VALUES
(NULL, 'Botella de Cola', 50, 10, TRUE, TRUE, 0.80),
(NULL, 'Monster Zero', 30, 5, TRUE, TRUE, 1.20),
(NULL, 'Cerveza Zero', 15, 5, FALSE, TRUE, 2.50),
(NULL, 'Cajas de galletas Zero', 40, 10, TRUE, FALSE, 1.75),
(NULL, 'Prueba1', 40, 10, TRUE, FALSE, 1.75),
(NULL, 'Prueba2', 40, 10, TRUE, FALSE, 1.75),
(NULL, 'Prueba3', 40, 10, TRUE, FALSE, 1.75),
(NULL, 'Prueba4', 40, 10, TRUE, FALSE, 1.75),
(NULL, 'Prueba5', 40, 10, TRUE, FALSE, 1.75),
(NULL, 'Prueba6', 40, 10, TRUE, FALSE, 1.75);

INSERT INTO products (image, name, amount, minimum_amount, season, enabled, price) VALUES
(NULL, 'Prueba124', 50, 10, TRUE, TRUE, 0.80);

INSERT INTO invoices (user_id, CIF, total, paid) VALUES
(1, 'G66699666', 14.00, TRUE),
(1, 'L99966999', 50.00, FALSE),
(2, 'S10111000', 30.00, TRUE);

INSERT INTO product_invoice (invoice_id, product_id, quantity, unit_price) VALUES
(1, 1, 10,1.50), -- 10 botellas de agua en el albarán 1
(1, 2, 5,2.30),  -- 5 monsters en el albarán 1
(2, 3, 12,1.90), -- 12 cervezas en el albarán 2
(3, 4, 20,19.35); -- 20 cajas de galletas en el albarán 3

-- ******************************************************************************
-- Podria ser intresante no guardar las imagenes como bloob si no la url de la imagen y la imagen dentro de una carpeta (uploads) dentro servidor
