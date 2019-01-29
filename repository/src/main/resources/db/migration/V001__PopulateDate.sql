INSERT INTO role (name) VALUES ('ROLE_ADMIN'), ('ROLE_DOCTOR'), ('ROLE_MANAGER'),('ROLE_PATIENT'), ('ROLE_RECEPTIONIST');
INSERT INTO authority (name) VALUES
('PREVIEW_TREATMENT'),
    ('MANAGE_VISIT'),
    ('PREVIEW_VISIT'),
    ('PREVIEW_HEALTH_INSURANCE'),
    ('PREVIEW_DOCTORS'),
    ('REQUEST_MANAGE_VISIT');

INSERT INTO role_authorities (role_id, authorities_id) VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6);
INSERT INTO role_authorities (role_id, authorities_id) VALUES (2,5),(2,3);
INSERT INTO role_authorities (role_id, authorities_id) VALUES (4,1),(4,3);

INSERT INTO `zpm`.`address` (`id`, `country`, `flat_number`, `house_number`, `locality`, `postal_code`) VALUES ('1', 'Polska', '0', '82', 'Zwola', '08-420');

INSERT INTO `zpm`.`contact_details` (`id`, `phone_number`, `address_id`) VALUES ('1', '514444444', '1');

INSERT INTO `zpm`.`user` (`type`, `date_of_birth`, `email`, `fathers_first_name`, `first_name`, `gender`, `last_name`, `mothers_first_name`, `number_of_children`, `password`, `pesel`, `place_of_birth`, `underage`, `username`, `contact_details_id`) VALUES
('User', '1996-05-16', 'test@test.test', 'Krzysztof', 'Lukasz', 'MALE', 'Salamonik', 'Bozena', '1', '$2a$10$P5cdZlj89GWdDpxuz5yb8.N0oDrb60bf2DGddqDfQ3hivDmU4VPWe', '96051608359', 'Garwolin', 0, 'admin', '1'),
('User', '2018-12-06', 'test3@mail.test', 'Kazik', 'Adam', 'MALE', 'Adam', 'Bogna', '1', '$2a$10$VyE.YI0hg./kbF6cpD9UI.dSj8kjxJ5s/Rg5HrB3w.VBkSlU5FJy', '12345678899', 'Warszawa', 0, 'Test3', '1');

INSERT INTO `zpm`.`user` (`type`, `date_of_birth`, `email`, `fathers_first_name`, `first_name`, `gender`, `last_name`, `mothers_first_name`, `number_of_children`, `password`, `pesel`, `place_of_birth`, `underage`, `username`, `contact_details_id`, number) VALUES
('PATIENT', '2018-12-06', 'test4@mail.test', 'Marcin', 'Adam', 'MALE', 'Druciak', 'Bogna', '1', '$2a$10$VyE.YI0hg./kbF6cpD9UI.dSj8kjxJ5s/Rg5HrB3w.VBkSlU5FJy', '12345678899', 'Warszawa', 0, 'Patient1', '1', 666),
('PATIENT', '2018-12-06', 'test5@mail.test', 'Wacek', 'Kamil', 'MALE', 'Gęba', 'Bogna', '1', '$2a$10$VyE.YI0hg./kbF6cpD9UI.dSj8kjxJ5s/Rg5HrB3w.VBkSlU5FJy', '12345678899', 'Warszawa', 0, 'Patient2', '1', 333);

INSERT INTO `zpm`.`user` (`type`, `date_of_birth`, `email`, `fathers_first_name`, `first_name`, `gender`, `last_name`, `mothers_first_name`, `number_of_children`, `password`, `pesel`, `place_of_birth`, `underage`, `username`, `contact_details_id`, pwz, length_of_visit) VALUES
('DOCTOR', '2018-12-06', 'test6@mail.test', 'Leszek', 'Adam', 'MALE', 'Bednarski', 'Bogna', '1', '$2a$10$VyE.YI0hg./kbF6cpD9UI.dSj8kjxJ5s/Rg5HrB3w.VBkSlU5FJy', '12345678899', 'Warszawa', 0, 'Doctor1','1', '1233', 15),
('DOCTOR', '2018-12-06', 'test7@mail.test', 'Gacer', 'Waclaw', 'MALE', 'Dongi', 'Bogna', '1', '$2a$10$VyE.YI0hg./kbF6cpD9UI.dSj8kjxJ5s/Rg5HrB3w.VBkSlU5FJy', '12345678899', 'Warszawa', 0, 'Doctor2','1', '4324',20),
('DOCTOR', '2018-12-06', 'test8@mail.test', 'Bernards', 'Ola', 'FEMALE', 'Ciula', 'Bogna', '1', '$2a$10$VyE.YI0hg./kbF6cpD9UI.dSj8kjxJ5s/Rg5HrB3w.VBkSlU5FJy', '12345678899', 'Warszawa', 0, 'Doctor3','1', '5432',25),
('DOCTOR', '2018-12-06', 'test9@mail.test', 'Leszek', 'Tadeusz', 'MALE', 'Drozd', 'Bogna', '1', '$2a$10$VyE.YI0hg./kbF6cpD9UI.dSj8kjxJ5s/Rg5HrB3w.VBkSlU5FJy', '12345678899', 'Warszawa', 0, 'Doctor4','1', '1133',10),
('DOCTOR', '2018-12-06', 'test10@mail.test', 'Gacer', 'Piotr', 'MALE', 'Grębarski', 'Bogna', '1', '$2a$10$VyE.YI0hg./kbF6cpD9UI.dSj8kjxJ5s/Rg5HrB3w.VBkSlU5FJy', '12345678899', 'Warszawa', 0, 'Doctor5','1', '1324',20),
('DOCTOR', '2018-12-06', 'test11@mail.test', 'Tomasz', 'Janina', 'FEMALE', 'Puta', 'Bogna', '1', '$2a$10$VyE.YI0hg./kbF6cpD9UI.dSj8kjxJ5s/Rg5HrB3w.VBkSlU5FJy', '12345678899', 'Warszawa', 0, 'Doctor6','1', '5032',25);

INSERT INTO `zpm`.`address` (`country`, `house_number`, `locality`, `postal_code`) VALUES
('Polska', '22', 'Warszawa', '01-432'),
('Polska', '43', 'Kraków', '01-432'),
('Polska', '12', 'Gdańsk', '01-432'),
('Polska', '2', 'Warszawa', '01-432'),
('Polska', '180', 'Gdańsk', '04-432'),
('Polska', '29', 'Garwolin', '03-432'),
('Polska', '60', 'Białystok', '02-432'),
 ('Polska', '22', 'Katowice', '11-753');

INSERT INTO `zpm`.`medical_centre` (`nip`, `regon`, `bank_account`, `name`, `address_entity_id`) VALUES
('5278502965', '048502634', '8124000011642233366023812', 'Centrum Medyczne CMP Żoliborz', '2'),
('7993374027', '454169351', '74137011095667540405117757', 'Przychodnia MULTI MED Warszawa Okopowa', '3'),
('8230396218', '374779433', '47124048520240709220226018', 'Alkamed Przychodnia', '4'),
('3818391973', '939580938', '20124011838311992989060981', 'NZOZ Ośrodek Pomocy Zdrowiu', '5'),
('1166640307', '276605077', '20881600015701141276351893', 'Centrum Medyczne Synexus ', '6'),
('1084206800', '917120970', '49144010848915433574673099', 'Centrum Medyczne Enel-Med Przychodnia', '7'),
('5191805822', '834736646', '49817000087028961163355707', 'Przychodnia Lekarska MediSpace', '8'),
('9326859586', '854988823', '68808500050558640207324248', 'Centrum Medyczne POLMED', '3'),
('9783095747', '035264660', '12193018718870711939315967', 'Specjalistyczna przychodnia lekarska Fundacji Pomocy na Rzecz Żołnierzy Armii Krajowej', '4'),
('5331304328', '156609697', '38820010212539495497036506', 'Przychodnia Lekarska', '9');

INSERT INTO `zpm`.`medical_centre_doctors` (`medical_centre_id`, `doctors_id`) VALUES
('1', '5'),
('1', '6'),
 ('3', '7'),
 ('2', '8'),
 ('4', '9'),
 ('5', '6'),
 ('6', '7'),
 ('7', '8'),
 ('8', '9'),
 ('9', '10'),
 ('10', '10'),
 ('10', '6'),
 ('9', '5'),
 ('8', '6'),
 ('7', '7'),
 ('6', '8'),
 ('5', '9'),
 ('4', '10');

INSERT INTO user_roles(user_id, roles_id) VALUES
(1,1),
(2,1),
(3,4),
(4,4),
(5,2),
(6,2),
(7,2),
(8,2),
(9,2),
(10,2);

INSERT INTO `zpm`.`surgery` (`id`, `color`, `day_of_week`, `starting_time`, `finishing_time`, `title`) VALUES
('1', '#ad2121', 'MONDAY', '08:28:55', '19:28:55', 'Jaca praca'),
('2', '#ad2121', 'TUESDAY', '08:28:55', '17:28:55', 'Job'),
('3', '#ad2121', 'WEDNESDAY', '08:28:55', '16:28:55', 'praca'),
('4', '#ad2121', 'THURSDAY', '08:28:55', '16:28:55', 'praca'),
('5', '#ad2121', 'FRIDAY', '08:28:55', '16:28:55', 'praca'),
('6', '#ad2121', 'SATURDAY', '08:28:55', '16:28:55', 'praca'),
('7', '#ad2121', 'SUNDAY', '08:28:55', '16:28:55', 'praca'),
('8', '#ad2121', 'SUNDAY', '08:28:55', '16:28:55', 'praca'), #niewazny
('9', '#ad2121', 'MONDAY', '08:28:55', '19:28:55', 'Jaca praca'),
('10', '#ad2121', 'TUESDAY', '08:28:55', '17:28:55', 'Job'),
('11', '#ad2121', 'WEDNESDAY', '08:28:55', '16:28:55', 'praca'),
('12', '#ad2121', 'THURSDAY', '08:28:55', '16:28:55', 'praca'),
('13', '#ad2121', 'FRIDAY', '08:28:55', '16:28:55', 'praca'),
('14', '#ad2121', 'SATURDAY', '08:28:55', '16:28:55', 'praca'),
('15', '#ad2121', 'SUNDAY', '08:28:55', '16:28:55', 'praca'),

('16', '#ad2121', 'MONDAY', '08:28:55', '19:28:55', 'Jaca praca'),
('17', '#ad2121', 'TUESDAY', '08:28:55', '17:28:55', 'Job'),
('18', '#ad2121', 'WEDNESDAY', '08:28:55', '16:28:55', 'praca'),
('19', '#ad2121', 'THURSDAY', '08:28:55', '16:28:55', 'praca'),
('20', '#ad2121', 'FRIDAY', '08:28:55', '16:28:55', 'praca'),
('21', '#ad2121', 'SATURDAY', '08:28:55', '16:28:55', 'praca'),
('22', '#ad2121', 'SUNDAY', '08:28:55', '16:28:55', 'praca'),

('23', '#ad2121', 'MONDAY', '08:28:55', '19:28:55', 'Jaca praca'),
('24', '#ad2121', 'TUESDAY', '08:28:55', '17:28:55', 'Job'),
('25', '#ad2121', 'WEDNESDAY', '08:28:55', '16:28:55', 'praca'),
('26', '#ad2121', 'THURSDAY', '08:28:55', '16:28:55', 'praca'),
('27', '#ad2121', 'FRIDAY', '08:28:55', '16:28:55', 'praca'),
('28', '#ad2121', 'SATURDAY', '08:28:55', '16:28:55', 'praca'),
('29', '#ad2121', 'SUNDAY', '08:28:55', '16:28:55', 'praca');

INSERT INTO `zpm`.`schedule` (`id`, `medical_centre_id`) VALUES
 (1,1),
 (2,2),
 (3,3),
 (4,4),
 (5,5),
 (6,6),
 (7,7),
 (8,7),
 (9,3),
 (10,9),
 (11,10);

#doktor numer 5 pracuje w 9 i 1
#doktor numer 6 pracuje w 10
INSERT INTO `zpm`.`user_schedules` (`doctor_id`, `schedules_id`) VALUES
(5, 1),
(6, 5),
(7, 8),
(8, 2),
(9, 7),
(10,4),
(7,9),
(5,10),
(6,11);

INSERT INTO `zpm`.`schedule_surgeries` (`schedule_id`, `surgeries_id`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(9, 10),
(9, 11),
(9, 12),
(9, 13),
(9, 14),
(9, 15),
(10,16),
(10,17),
(10,18),
(10,19),
(10,20),
(10,21),
(10,22),
(11,23),
(11,24),
(11,25),
(11,26),
(11,27),
(11,28),
(11,29);

INSERT INTO `zpm`.`specialization` (`name`) VALUES
('Alergologia'),
('Anestesjologia'),
('Chirurgia ogólna'),
('Chirurgia dziecięca'),
('Chirurgia onkologiczna'),
('Diabetologia'),
('Endokrynologia'),
('Gastroenterologia'),
('Genetyka kliniczna'),
('Geriatria'),
('KArdiologia'),
('Medycyna pracy'),
('Neurochirurgia'),
('Okulistyka'),
('Onkologia klininczna'),
('Pediatria'),
('Reumatologia'),
('Urologia');

INSERT INTO `zpm`.`user_specializations` (`doctor_id`, `specializations_id`) VALUES
 ('5', '1'),
 ('5', '2'),
 ('6', '2'),
 ('6', '3'),
 ('6', '4'),
 ('7', '5'),
 ('7', '6'),
 ('8', '7'),
 ('8', '8'),
 ('8', '9'),
 ('8', '10'),
 ('9', '11'),
 ('10', '12');
