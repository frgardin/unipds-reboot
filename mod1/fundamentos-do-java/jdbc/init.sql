use cardapio;

create table item_cardapio (
	id bigint primary key auto_increment,
	nome varchar(100) not null,
	descricao text,
	categoria enum('ENTRADAS', 'PRATOS_PRINCIPAIS', 'BEBIDAS', 'SOBREMESA') not null,
	preco DECIMAL(9, 2) not null,
	preco_promocional DECIMAL(9, 2)
);

select * from item_cardapio;

select count(*) from item_cardapio;

insert into item_cardapio(nome, descricao, categoria, preco, preco_promocional)
values ('Refresco do Chaves', 'Suco de limao que parece de tamarinho e tem gosto de groselha', 'BEBIDAS', 2.99, null),
       ('Bruschetta Italiana', 'Fatias de pao tostado com tomate, manjericao e azeite', 'ENTRADAS', 18.90, 14.90),
       ('Bolinho de Bacalhau', 'Bolinhos crocantes de bacalhau com ervas finas', 'ENTRADAS', 24.50, null),
       ('Frango Grelhado', 'Peito de frango grelhado com legumes e arroz', 'PRATOS_PRINCIPAIS', 42.00, 38.00),
       ('Picanha na Brasa', 'Picanha grelhada ao ponto com farofa e vinagrete', 'PRATOS_PRINCIPAIS', 89.90, null),
       ('Moqueca de Camarao', 'Moqueca baiana com camarao fresco, leite de coco e dendê', 'PRATOS_PRINCIPAIS', 74.50, 65.00),
       ('Suco de Laranja', 'Suco de laranja natural espremido na hora', 'BEBIDAS', 9.90, null),
       ('Refrigerante Lata', 'Coca-Cola, Guarana ou Sprite 350ml', 'BEBIDAS', 7.00, null),
       ('Agua com Gas', 'Agua mineral com gas 500ml', 'BEBIDAS', 5.50, null),
       ('Pudim de Leite', 'Pudim de leite condensado com calda de caramelo', 'SOBREMESA', 16.00, 12.00),
       ('Mousse de Maracuja', 'Mousse cremoso de maracuja com cobertura de geleia', 'SOBREMESA', 14.50, null),
       ('Petit Gateau', 'Bolinho quente de chocolate com sorvete de creme', 'SOBREMESA', 28.00, 22.00);

