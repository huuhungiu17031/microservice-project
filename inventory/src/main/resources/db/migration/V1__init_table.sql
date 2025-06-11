CREATE TABLE IF NOT EXISTS inventories (
    id                 SERIAL PRIMARY KEY,
    inventory_name     VARCHAR(255) NOT NULL,
    inventory_location VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS products (
    id           SERIAL PRIMARY KEY,
    product_name VARCHAR(255),
    description  TEXT,
    price        INT NOT NULL DEFAULT 0,
    shop_id      INT NOT NULL
);

CREATE TABLE IF NOT EXISTS inventory_product (
    id            SERIAL PRIMARY KEY,
    inventory_id  INT NOT NULL,
    product_id    INT NOT NULL,
    quantity      INT NOT NULL DEFAULT 0
);

-- Add foreign key constraint for inventory_id
DO $$
BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM information_schema.table_constraints
        WHERE constraint_name = 'fk_inventory_id'
    ) THEN
        ALTER TABLE inventory_product
        ADD CONSTRAINT fk_inventory_id
        FOREIGN KEY (inventory_id)
        REFERENCES inventories(id)
        ON DELETE CASCADE;
    END IF;
END $$;

-- Add foreign key constraint for product_id
DO $$
BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM information_schema.table_constraints
        WHERE constraint_name = 'fk_product_id'
    ) THEN
        ALTER TABLE inventory_product
        ADD CONSTRAINT fk_product_id
        FOREIGN KEY (product_id)
        REFERENCES products(id)
        ON DELETE CASCADE;
    END IF;
END $$;
