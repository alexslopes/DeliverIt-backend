create table dados_pagamento_model (
        id integer not null,
        nome varchar(50) not null,
        data_pagamento timestamp not null,
        data_vencimento timestamp not null,
        dias_em_atraso integer not null,
        juros double not null,
        multa double not null,
        valor_corrigido double not null,
        valor_original double not null,
        primary key (id)
    )