-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;



---Insert de clientes:

-- INSERT INTO cliente (id, nome, email, nascimento) values (1, 'Caio Machado', 'caio@gmail.com', '1999-01-31');
-- INSERT INTO cliente (id, nome, email, nascimento) values (2, 'Renan Vicente', 'renan@gmail.com', '1999-01-31');
-- INSERT INTO cliente (id, nome, email, nascimento) values (3, 'Maria Costa', 'maria@gmail.com', '1999-01-31');
-- INSERT INTO cliente (id, nome, email, nascimento) values (4, 'Lucas Gomes', 'lucas@gmail.com', '1999-01-31');
-- INSERT INTO cliente (id, nome, email, nascimento) values (5, 'Júlia Rodrigues', 'julia@gmail.com', '1999-01-31');
-- INSERT INTO cliente (id, nome, email, nascimento) values (6, 'Carlos Silva', 'carlos@gmail.com', '1999-01-31');
-- INSERT INTO cliente (id, nome, email, nascimento) values (7, 'Pedro Oliveira', 'pedro@gmail.com', '1999-01-31');
-- INSERT INTO cliente (id, nome, email, nascimento) values (8, 'Beatriz Oliveira', 'beatriz@gmail.com', '1999-01-31');
-- INSERT INTO cliente (id, nome, email, nascimento) values (9, 'Maria Souza', 'maria@gmail.com', '1999-01-31');
-- INSERT INTO cliente (id, nome, email, nascimento) values (10, 'Pedro Martins', 'pedro@gmail.com', '1999-01-31');
-- INSERT INTO cliente (id, nome, email, nascimento) values (11, 'Carlos Silva', 'carlos@gmail.com', '1999-11-30');


---Insert de notícias:

-- insert into noticia (id, descricao, titulo, url, processada) values (1, 'Proposta premiada pela Anatel levaria aparelho pirata a baixar atualização que impede seu funcionamento. Agência disse que está conversando com grupo que sugeriu a medida, mas não confirmou se ela será implementada.', 'Pane geral em TV boxes piratas: como é a solução que promete combater caixinhas irregulares', 'https://g1.globo.com/tecnologia/noticia/2024/11/15/pane-geral-em-tv-boxes-piratas-como-e-a-solucao-que-promete-combater-caixinhas-irregulares.ghtml', false);
-- insert into noticia (id, descricao, titulo, url, processada) values (2, 'Número de reclamações atingiu pico por volta das 17h20 e começou a cair logo depois, segundo o Downdetector, site que monitora funcionamento de plataformas digitais.', 'Usuários relatam instabilidade no Instagram', 'https://g1.globo.com/tecnologia/noticia/2024/11/14/usuarios-relatam-instabilidade-no-instagram.ghtml', false);
-- insert into noticia (id, descricao, titulo, url, processada) values (3, 'Até então, o concorrente do ChatGPT só tinha um aplicativo próprio para Android. Ferramenta pode gerar textos, imagens e códigos de programação a partir de instruções curtas.', 'Google começa a liberar aplicativo do robô Gemini para iPhone', 'https://g1.globo.com/tecnologia/noticia/2024/11/14/google-comeca-a-liberar-robo-gemini-para-iphone.ghtml', false);
-- insert into noticia (id, descricao, titulo, url, processada) values (4, 'O serviço de gerenciamento de senhas NordPass divulgou o relatório anual da empresa com a lista de senhas mais populares do mundo. ', 'Relatório revela as piores senhas para usar em 2024', 'https://www.tecmundo.com.br/seguranca/400150-relatorio-revela-as-piores-senhas-para-usar-em-2024-ate-gabriel-esta-na-lista.htm', false);
-- insert into noticia (id, descricao, titulo, url, processada) values (5, 'Mais de 1,3 milhão de espécies de plantas ficam armazenadas em meio ao solo congelado do arquipélago de Svalbard', '“Cofre do apocalipse”: banco de sementes na Noruega pode salvar a humanidade', 'https://www.cnnbrasil.com.br/tecnologia/cofre-do-apocalipse-banco-de-sementes-na-noruega-pode-salvar-a-humanidade/', false);
-- insert into noticia (id, descricao, titulo, url, processada) values (6, 'De uma hora para outra, os curitibanos que passavam pela Praça do Paço tomaram um susto: pelo chão, ovos fritos gigantes atrapalhavam sua caminhada. ', 'Por que Curitiba está com ovos fritos gigantes espalhados pela cidade?', 'https://www.megacurioso.com.br/artes-cultura/por-que-curitiba-esta-com-ovos-fritos-gigantes-espalhados-pela-cidade', false);
-- insert into noticia (id, descricao, titulo, url, processada) values (7, 'No dia 13 de novembro de 2024, o Congresso dos Estados Unidos realizou uma nova audiência sobre o mistério dos OVNIs (UFOs e UAPs). ', 'Congresso dos EUA e OVNIs: o que foi revelado na segunda audiência sobre UFOs', 'https://www.tecmundo.com.br/ciencia/400160-congresso-dos-eua-e-ovnis-o-que-foi-revelado-na-segunda-audiencia-sobre-ufos.htm', false);
-- insert into noticia (id, descricao, titulo, url, processada) values (8, 'Não será enviada', 'Notícia processada', 'https://www.teste.com', true);
-- insert into noticia (id, descricao, titulo, url, processada) values (9, 'Mais de 30 mil pessoas foram tratadas por doenças respiratórias em distritos atingidos pelo ar contaminado.', 'Poluição no Paquistão pode ser vista do espaço', 'https://www.cnnbrasil.com.br/internacional/poluicao-no-paquistao-pode-ser-vista-do-espaco/',false);