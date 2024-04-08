-- Wstawianie danych do tabeli categories
INSERT INTO categories (id, name) VALUES
                                      ('7c89669b-e5eb-49cd-8d5e-512e3c1fbc9a', 'Zupy'),
                                      ('0d1d788b-913a-4a2b-934b-ebf44e487f37', 'Sałatki'),
                                      ('1f4ff8b2-21b2-4ee5-a5e4-f5391bfedff3', 'Dania główne'),
                                      ('f6a17f8e-16e5-4c14-b13d-7752c1fb4288', 'Makarony'),
                                      ('fe68c819-3b12-4db4-9fe6-7cd43d2e1799', 'Desery');

-- Wstawianie danych do tabeli dishes
INSERT INTO dishes (id, name, category_id) VALUES
                                               ('c398f5e1-3b11-4c12-b35d-281ad5eaa06e', 'Zupa z Kurczaka', '7c89669b-e5eb-49cd-8d5e-512e3c1fbc9a'),
                                               ('e89327cb-d28c-4760-85d0-290d2ac1b012', 'Sałatka Warzywna', '0d1d788b-913a-4a2b-934b-ebf44e487f37'),
                                               ('a798527c-b8b1-4b08-9ff1-4d6ac964ecf3', 'Stek Grillowany', '1f4ff8b2-21b2-4ee5-a5e4-f5391bfedff3'),
                                               ('e72d8b73-2181-4605-92f7-5a6f4d2b8dbb', 'Makaron Carbonara', 'f6a17f8e-16e5-4c14-b13d-7752c1fb4288'),
                                               ('bea1f7a4-20df-4d05-8817-0675cd7b02b1', 'Tacos z Rybą', '1f4ff8b2-21b2-4ee5-a5e4-f5391bfedff3'),
                                               ('f4959e7d-04da-4fb9-b2b0-5ecff36540da', 'Brownie Czekoladowe', 'fe68c819-3b12-4db4-9fe6-7cd43d2e1799'),
                                               ('be78114d-f8ef-41b2-9ea2-6550c0c09d46', 'Pizza Margherita', '1f4ff8b2-21b2-4ee5-a5e4-f5391bfedff3'),
                                               ('7c1a66b3-741a-4f7e-8182-989d78f731ef', 'Curry Wegańskie', '1f4ff8b2-21b2-4ee5-a5e4-f5391bfedff3'),
                                               ('2e5cdefa-6c3f-43c2-9086-c79a5a7da9f2', 'Klasyczna Sałatka Cezar', '0d1d788b-913a-4a2b-934b-ebf44e487f37'),
                                               ('43c64d3d-396a-4eb5-bc5e-0c0059ecde46', 'Naleśniki z Jagodami', 'fe68c819-3b12-4db4-9fe6-7cd43d2e1799'),
                                               ('3ef2b883-065b-4f8a-95e5-36f4cc9e4cf3', 'Szakszuka', '1f4ff8b2-21b2-4ee5-a5e4-f5391bfedff3'),
                                               ('4d78f9c0-ec30-4851-968a-9d8e5a4b21d7', 'Pad Thai', '1f4ff8b2-21b2-4ee5-a5e4-f5391bfedff3'),
                                               ('9fbb905f-b01a-4c7e-b51b-85e26bf0c4b2', 'Risotto z Grzybami', '1f4ff8b2-21b2-4ee5-a5e4-f5391bfedff3'),
                                               ('94f18e8d-fb3c-4ff7-a3e7-17fc3f9f4b2b', 'Gazpacho', '7c89669b-e5eb-49cd-8d5e-512e3c1fbc9a'),
                                               ('bfda20c7-6b2d-41f4-ba1b-d77692418b97', 'Ratatouille', '1f4ff8b2-21b2-4ee5-a5e4-f5391bfedff3'),
                                               ('5d0c1853-e0d4-4b0b-8580-ee334f2589d7', 'Bibimbap', '1f4ff8b2-21b2-4ee5-a5e4-f5391bfedff3'),
                                               ('9b22c7f0-df97-46a7-8b79-8ef415ac1b2b', 'Tiramisu', 'fe68c819-3b12-4db4-9fe6-7cd43d2e1799'),
                                               ('18e2e6d8-5a5a-44ed-88ad-4f63af3a991b', 'Falafel', '1f4ff8b2-21b2-4ee5-a5e4-f5391bfedff3'),
                                               ('ccf45b6f-4d9a-449f-b77b-0e69dadd19dd', 'Musaka', '1f4ff8b2-21b2-4ee5-a5e4-f5391bfedff3');

-- Wstawianie danych do tabeli recipes z uwzględnieniem kroków
INSERT INTO recipes (id, steps, dish_id) VALUES
                                             ('bf9964c5-030b-4a3b-bb9c-3e9aaffbb30c', 'Krok 1: Przygotuj składniki.\nKrok 2: Gotuj kurczaka w bulionie.\nKrok 3: Dodaj warzywa i przyprawy.\nKrok 4: Gotuj do miękkości.\nKrok 5: Podawaj gorącą.', 'c398f5e1-3b11-4c12-b35d-281ad5eaa06e'),
                                             ('e8cfd7d5-b65e-4c04-84b8-5b2a5e257a5a', 'Krok 1: Pokrój warzywa.\nKrok 2: Przygotuj sos.\nKrok 3: Wymieszaj wszystko razem.\nKrok 4: Dopraw do smaku.\nKrok 5: Podawaj schłodzoną.', 'e89327cb-d28c-4760-85d0-290d2ac1b012'),
                                             ('fbc14f0d-2ad0-46cc-95c5-36b1d659ba1c', 'Krok 1: Przygotuj mięso i przyprawy.\nKrok 2: Grilluj na rozgrzanym grillu.\nKrok 3: Obracaj co kilka minut.\nKrok 4: Podawaj ze składnikami dodatkowymi.', 'a798527c-b8b1-4b08-9ff1-4d6ac964ecf3'),
                                             ('3cf9df23-0a1a-4a09-965a-18d1568833b0', 'Krok 1: Ugotuj makaron al dente.\nKrok 2: Smaż boczek na patelni.\nKrok 3: Dodaj jajka i parmezan.\nKrok 4: Wymieszaj z makaronem.\nKrok 5: Podawaj z posiekaną natką pietruszki.', 'e72d8b73-2181-4605-92f7-5a6f4d2b8dbb'),
                                             ('f1f2822e-f0af-45cf-a9fd-125fc28ed4f4', 'Krok 1: Przygotuj składniki.\nKrok 2: Smaż rybę na patelni.\nKrok 3: Dostosuj przyprawy według upodobań.\nKrok 4: Napełnij tortille rybą i dodatkami.\nKrok 5: Podawaj z limonką.', 'bea1f7a4-20df-4d05-8817-0675cd7b02b1'),
                                             ('2f518289-8493-4822-af41-5f2f8e80c5fc', 'Krok 1: Rozpuść czekoladę z masłem.\nKrok 2: Ubij jajka z cukrem.\nKrok 3: Dodaj czekoladę do masy jajecznej.\nKrok 4: Wymieszaj z mąką i kakao.\nKrok 5: Piecz przez 25 minut.', 'f4959e7d-04da-4fb9-b2b0-5ecff36540da'),
                                             ('35bb3a8f-2ee1-4e50-8ee5-d6d3b11ab8e4', 'Krok 1: Przygotuj ciasto na pizzę.\nKrok 2: Posmaruj sos pomidorowy na cieście.\nKrok 3: Połóż plasterki pomidora i mozzarellę.\nKrok 4: Posyp bazylią.\nKrok 5: Piecz przez 15-20 minut.', 'be78114d-f8ef-41b2-9ea2-6550c0c09d46'),
                                             ('163007d3-67cf-48f2-821d-6b4d27c6b22d', 'Krok 1: Przygotuj warzywa i tofu.\nKrok 2: Smaż cebulę i czosnek.\nKrok 3: Dodaj warzywa, mleczko kokosowe i przyprawy.\nKrok 4: Gotuj na wolnym ogniu.\nKrok 5: Podawaj z ryżem.', '7c1a66b3-741a-4f7e-8182-989d78f731ef'),
                                             ('bcf1533a-e8a4-429f-bab8-840ce236632d', 'Krok 1: Przygotuj składniki.\nKrok 2: Udekoruj sałatkę.\nKrok 3: Dodaj sos Caesar.\nKrok 4: Posyp startym parmezanem.\nKrok 5: Podawaj ze świeżą bagietką.', '2e5cdefa-6c3f-43c2-9086-c79a5a7da9f2'),
                                             ('0156505e-9fcf-4e17-ae1b-3da47821f2b5', 'Krok 1: Przygotuj ciasto na naleśniki.\nKrok 2: Smaż naleśniki na patelni.\nKrok 3: Przygotuj nadzienie z jagód.\nKrok 4: Nadziewaj i zwijaj naleśniki.\nKrok 5: Posyp cukrem pudrem.', '43c64d3d-396a-4eb5-bc5e-0c0059ecde46'),
                                             ('9f6019d1-9d39-4c15-bf5b-9af3dc6b4376', 'Krok 1: Smaż cebulę na patelni.\nKrok 2: Dodaj pomidory i przyprawy.\nKrok 3: Wbij jajka i smaż do ścięcia.\nKrok 4: Podawaj z chlebem.', '3ef2b883-065b-4f8a-95e5-36f4cc9e4cf3'),
                                             ('c2e4fd0e-f8d9-4e21-862a-e3cc141a2fd0', 'Krok 1: Namocz makaron ryżowy.\nKrok 2: Smaż tofu i warzywa.\nKrok 3: Dodaj makaron i sos.\nKrok 4: Smaż razem.\nKrok 5: Podawaj z orzeszkami ziemnymi i kolendrą.', '4d78f9c0-ec30-4851-968a-9d8e5a4b21d7'),
                                             ('cdefb4e3-1b89-4139-8202-f5183036f6f7', 'Krok 1: Smaż cebulę i czosnek.\nKrok 2: Dodaj ryż i podgrzewaj.\nKrok 3: Stopniowo dodawaj bulion i gotuj.\nKrok 4: Smaż grzyby i dodaj do risotto.\nKrok 5: Podawaj posypane parmezanem.', '9fbb905f-b01a-4c7e-b51b-85e26bf0c4b2'),
                                             ('82a8a73d-57ed-4771-9a1b-d63e178f4876', 'Krok 1: Pokrój pomidory i ogórki.\nKrok 2: Włóż do blendera z czosnkiem i papryką.\nKrok 3: Dodaj oliwę i ocet.\nKrok 4: Zblenduj na gładki sos.\nKrok 5: Schładzaj przed podaniem.', '94f18e8d-fb3c-4ff7-a3e7-17fc3f9f4b2b'),
                                             ('ed09c383-7dd2-41cd-9b43-8c4445258e8c', 'Krok 1: Pokrój warzywa.\nKrok 2: Smaż cebulę, czosnek i paprykę.\nKrok 3: Dodaj pokrojone pomidory i cukinię.\nKrok 4: Gotuj na wolnym ogniu.\nKrok 5: Podawaj z bagietką.', 'bfda20c7-6b2d-41f4-ba1b-d77692418b97'),
                                             ('7008a9d1-4a18-4b4a-b4cf-7cfb83c3ef48', 'Krok 1: Przygotuj składniki.\nKrok 2: Smaż mięso i warzywa.\nKrok 3: Przygotuj ryż.\nKrok 4: Ułóż składniki na wierzchu ryżu.\nKrok 5: Posyp sezamem i polej sosem.', '5d0c1853-e0d4-4b0b-8580-ee334f2589d7'),
                                             ('4c0a79d1-1883-442b-83cf-5411cb10bf1b', 'Krok 1: Ubij jajka z cukrem.\nKrok 2: Dodaj mascarpone i wymieszaj.\nKrok 3: Mocz biszkopty w kawie.\nKrok 4: Układaj warstwy biszkoptów i kremu.\nKrok 5: Posyp kakao.', '9b22c7f0-df97-46a7-8b79-8ef415ac1b2b'),
                                             ('d2c2b034-015f-45ad-a9ae-ee218b61ad6a', 'Krok 1: Mocz ciecierzycę przez noc.\nKrok 2: Zmiel ciecierzycę z przyprawami.\nKrok 3: Formuj kulki i smaż na oleju.\nKrok 4: Podawaj z hummusem i pitą.', '18e2e6d8-5a5a-44ed-88ad-4f63af3a991b'),
                                             ('a76f1d63-d8e4-4b6d-9ec4-60563475f5f7', 'Krok 1: Przygotuj składniki.\nKrok 2: Smaż mięso i warzywa.\nKrok 3: Warstwuj warzywa, mięso i ziemniaki w naczyniu.\nKrok 4: Zalej sosem beszamelowym.\nKrok 5: Piecz przez godzinę.', 'ccf45b6f-4d9a-449f-b77b-0e69dadd19dd');

