-- 학생정보(학생번호, 이름, 연락처, 주소, 생년월일)
--tbl_student 테이블명.
CREATE table tbl_student(
    std_no varchar2(10) PRIMARY key,
    std_name varchar2(100) not null,
    std_phone VARCHAR2(20),
    address VARCHAR2(100),
    birth_date date,
    creation_date date DEFAULT sysdate
);
-- 샘플데이터 넣기
insert into tbl_student(std_no, std_name, std_phone)
values('s2024-01','홍길동','010-1234-5678');

insert into tbl_student(std_no, std_name, std_phone, std_address)
values('s2024-02','김길동','010-3333-4444', '서울100번지');

insert into tbl_student(std_no, std_name, std_phone)
values('s2024-03','이승엽','010-1122-3344');

select * from tbl_student;

update tbl_student
set std_address = '대전 100'
where std_no = 's2024-01';

insert into tbl_student(std_no, std_name, std_phone)
values('s2024-04','김민규','010-2222-5566');

update tbl_student
set birth_date = to_date('19970505','yyyy-mm-dd'),
    std_address = '대전 300'
where std_no = 's2024-04';

commit;