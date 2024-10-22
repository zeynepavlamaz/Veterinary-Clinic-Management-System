PGDMP      9                {            vet    16.1    16.1 >    R           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            S           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            T           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            U           1262    16493    vet    DATABASE     e   CREATE DATABASE vet WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'C';
    DROP DATABASE vet;
                postgres    false            �            1259    16494    animal_vaccines    TABLE     �   CREATE TABLE public.animal_vaccines (
    id bigint NOT NULL,
    protection_end date NOT NULL,
    protection_start date NOT NULL,
    animal_id bigint,
    vaccine_id bigint
);
 #   DROP TABLE public.animal_vaccines;
       public         heap    postgres    false            �            1259    16497    animal_vaccines_id_seq    SEQUENCE        CREATE SEQUENCE public.animal_vaccines_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.animal_vaccines_id_seq;
       public          postgres    false    215            V           0    0    animal_vaccines_id_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.animal_vaccines_id_seq OWNED BY public.animal_vaccines.id;
          public          postgres    false    216            �            1259    16498    animals    TABLE     �  CREATE TABLE public.animals (
    id bigint NOT NULL,
    birthday date,
    breed character varying(255),
    colour character varying(255),
    gender character varying(255),
    name character varying(255),
    species character varying(255),
    customer_id bigint,
    CONSTRAINT animals_gender_check CHECK (((gender)::text = ANY (ARRAY[('MALE'::character varying)::text, ('FEMALE'::character varying)::text])))
);
    DROP TABLE public.animals;
       public         heap    postgres    false            �            1259    16504    animals_id_seq    SEQUENCE     w   CREATE SEQUENCE public.animals_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.animals_id_seq;
       public          postgres    false    217            W           0    0    animals_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.animals_id_seq OWNED BY public.animals.id;
          public          postgres    false    218            �            1259    16505    appointments    TABLE     �   CREATE TABLE public.appointments (
    id bigint NOT NULL,
    appointment_date timestamp(6) without time zone NOT NULL,
    animal_id bigint NOT NULL,
    doctor_id bigint NOT NULL
);
     DROP TABLE public.appointments;
       public         heap    postgres    false            �            1259    16508    appointments_id_seq    SEQUENCE     |   CREATE SEQUENCE public.appointments_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.appointments_id_seq;
       public          postgres    false    219            X           0    0    appointments_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.appointments_id_seq OWNED BY public.appointments.id;
          public          postgres    false    220            �            1259    16509 	   customers    TABLE       CREATE TABLE public.customers (
    id bigint NOT NULL,
    address character varying(255) NOT NULL,
    city character varying(255) NOT NULL,
    mail character varying(255),
    name character varying(255) NOT NULL,
    phone character varying(255) NOT NULL
);
    DROP TABLE public.customers;
       public         heap    postgres    false            �            1259    16514    customers_id_seq    SEQUENCE     y   CREATE SEQUENCE public.customers_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.customers_id_seq;
       public          postgres    false    221            Y           0    0    customers_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.customers_id_seq OWNED BY public.customers.id;
          public          postgres    false    222            �            1259    16515    doctor_available_days    TABLE     ~   CREATE TABLE public.doctor_available_days (
    id bigint NOT NULL,
    available_days date NOT NULL,
    doctor_id bigint
);
 )   DROP TABLE public.doctor_available_days;
       public         heap    postgres    false            �            1259    16518    doctor_available_days_id_seq    SEQUENCE     �   CREATE SEQUENCE public.doctor_available_days_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE public.doctor_available_days_id_seq;
       public          postgres    false    223            Z           0    0    doctor_available_days_id_seq    SEQUENCE OWNED BY     ]   ALTER SEQUENCE public.doctor_available_days_id_seq OWNED BY public.doctor_available_days.id;
          public          postgres    false    224            �            1259    16519    doctors    TABLE       CREATE TABLE public.doctors (
    id bigint NOT NULL,
    address character varying(255) NOT NULL,
    city character varying(255) NOT NULL,
    mail character varying(255),
    name character varying(255) NOT NULL,
    phone character varying(255) NOT NULL
);
    DROP TABLE public.doctors;
       public         heap    postgres    false            �            1259    16524    doctors_id_seq    SEQUENCE     w   CREATE SEQUENCE public.doctors_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.doctors_id_seq;
       public          postgres    false    225            [           0    0    doctors_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.doctors_id_seq OWNED BY public.doctors.id;
          public          postgres    false    226            �            1259    16525    vaccines    TABLE     �   CREATE TABLE public.vaccines (
    id bigint NOT NULL,
    code character varying(255),
    name character varying(255) NOT NULL
);
    DROP TABLE public.vaccines;
       public         heap    postgres    false            �            1259    16530    vaccines_id_seq    SEQUENCE     x   CREATE SEQUENCE public.vaccines_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.vaccines_id_seq;
       public          postgres    false    227            \           0    0    vaccines_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.vaccines_id_seq OWNED BY public.vaccines.id;
          public          postgres    false    228            �           2604    16531    animal_vaccines id    DEFAULT     x   ALTER TABLE ONLY public.animal_vaccines ALTER COLUMN id SET DEFAULT nextval('public.animal_vaccines_id_seq'::regclass);
 A   ALTER TABLE public.animal_vaccines ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    216    215            �           2604    16532 
   animals id    DEFAULT     h   ALTER TABLE ONLY public.animals ALTER COLUMN id SET DEFAULT nextval('public.animals_id_seq'::regclass);
 9   ALTER TABLE public.animals ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    218    217            �           2604    16533    appointments id    DEFAULT     r   ALTER TABLE ONLY public.appointments ALTER COLUMN id SET DEFAULT nextval('public.appointments_id_seq'::regclass);
 >   ALTER TABLE public.appointments ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    220    219            �           2604    16534    customers id    DEFAULT     l   ALTER TABLE ONLY public.customers ALTER COLUMN id SET DEFAULT nextval('public.customers_id_seq'::regclass);
 ;   ALTER TABLE public.customers ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    222    221            �           2604    16535    doctor_available_days id    DEFAULT     �   ALTER TABLE ONLY public.doctor_available_days ALTER COLUMN id SET DEFAULT nextval('public.doctor_available_days_id_seq'::regclass);
 G   ALTER TABLE public.doctor_available_days ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    224    223            �           2604    16536 
   doctors id    DEFAULT     h   ALTER TABLE ONLY public.doctors ALTER COLUMN id SET DEFAULT nextval('public.doctors_id_seq'::regclass);
 9   ALTER TABLE public.doctors ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    226    225            �           2604    16537    vaccines id    DEFAULT     j   ALTER TABLE ONLY public.vaccines ALTER COLUMN id SET DEFAULT nextval('public.vaccines_id_seq'::regclass);
 :   ALTER TABLE public.vaccines ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    228    227            B          0    16494    animal_vaccines 
   TABLE DATA           f   COPY public.animal_vaccines (id, protection_end, protection_start, animal_id, vaccine_id) FROM stdin;
    public          postgres    false    215   `H       D          0    16498    animals 
   TABLE DATA           b   COPY public.animals (id, birthday, breed, colour, gender, name, species, customer_id) FROM stdin;
    public          postgres    false    217   �H       F          0    16505    appointments 
   TABLE DATA           R   COPY public.appointments (id, appointment_date, animal_id, doctor_id) FROM stdin;
    public          postgres    false    219   tI       H          0    16509 	   customers 
   TABLE DATA           I   COPY public.customers (id, address, city, mail, name, phone) FROM stdin;
    public          postgres    false    221   �I       J          0    16515    doctor_available_days 
   TABLE DATA           N   COPY public.doctor_available_days (id, available_days, doctor_id) FROM stdin;
    public          postgres    false    223   `J       L          0    16519    doctors 
   TABLE DATA           G   COPY public.doctors (id, address, city, mail, name, phone) FROM stdin;
    public          postgres    false    225   �J       N          0    16525    vaccines 
   TABLE DATA           2   COPY public.vaccines (id, code, name) FROM stdin;
    public          postgres    false    227   /K       ]           0    0    animal_vaccines_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.animal_vaccines_id_seq', 7, true);
          public          postgres    false    216            ^           0    0    animals_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.animals_id_seq', 8, true);
          public          postgres    false    218            _           0    0    appointments_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.appointments_id_seq', 23, true);
          public          postgres    false    220            `           0    0    customers_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.customers_id_seq', 5, true);
          public          postgres    false    222            a           0    0    doctor_available_days_id_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.doctor_available_days_id_seq', 9, true);
          public          postgres    false    224            b           0    0    doctors_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.doctors_id_seq', 5, true);
          public          postgres    false    226            c           0    0    vaccines_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.vaccines_id_seq', 5, true);
          public          postgres    false    228            �           2606    16539 $   animal_vaccines animal_vaccines_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.animal_vaccines
    ADD CONSTRAINT animal_vaccines_pkey PRIMARY KEY (id);
 N   ALTER TABLE ONLY public.animal_vaccines DROP CONSTRAINT animal_vaccines_pkey;
       public            postgres    false    215            �           2606    16541    animals animals_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.animals
    ADD CONSTRAINT animals_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.animals DROP CONSTRAINT animals_pkey;
       public            postgres    false    217            �           2606    16543    appointments appointments_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.appointments
    ADD CONSTRAINT appointments_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.appointments DROP CONSTRAINT appointments_pkey;
       public            postgres    false    219            �           2606    16545    customers customers_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.customers
    ADD CONSTRAINT customers_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.customers DROP CONSTRAINT customers_pkey;
       public            postgres    false    221            �           2606    16547 0   doctor_available_days doctor_available_days_pkey 
   CONSTRAINT     n   ALTER TABLE ONLY public.doctor_available_days
    ADD CONSTRAINT doctor_available_days_pkey PRIMARY KEY (id);
 Z   ALTER TABLE ONLY public.doctor_available_days DROP CONSTRAINT doctor_available_days_pkey;
       public            postgres    false    223            �           2606    16549    doctors doctors_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.doctors
    ADD CONSTRAINT doctors_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.doctors DROP CONSTRAINT doctors_pkey;
       public            postgres    false    225            �           2606    16551 &   customers uk_2hxsqcqvp2pjgxw00gn7inubj 
   CONSTRAINT     a   ALTER TABLE ONLY public.customers
    ADD CONSTRAINT uk_2hxsqcqvp2pjgxw00gn7inubj UNIQUE (mail);
 P   ALTER TABLE ONLY public.customers DROP CONSTRAINT uk_2hxsqcqvp2pjgxw00gn7inubj;
       public            postgres    false    221            �           2606    16553 %   vaccines uk_7o57f9urdeta76xljqdidcsck 
   CONSTRAINT     `   ALTER TABLE ONLY public.vaccines
    ADD CONSTRAINT uk_7o57f9urdeta76xljqdidcsck UNIQUE (code);
 O   ALTER TABLE ONLY public.vaccines DROP CONSTRAINT uk_7o57f9urdeta76xljqdidcsck;
       public            postgres    false    227            �           2606    16555 &   customers uk_m3iom37efaxd5eucmxjqqcbe9 
   CONSTRAINT     b   ALTER TABLE ONLY public.customers
    ADD CONSTRAINT uk_m3iom37efaxd5eucmxjqqcbe9 UNIQUE (phone);
 P   ALTER TABLE ONLY public.customers DROP CONSTRAINT uk_m3iom37efaxd5eucmxjqqcbe9;
       public            postgres    false    221            �           2606    16557    vaccines vaccines_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.vaccines
    ADD CONSTRAINT vaccines_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.vaccines DROP CONSTRAINT vaccines_pkey;
       public            postgres    false    227            �           2606    16558 (   appointments fk95vepu86o8syqtux9gkr71bhy    FK CONSTRAINT     �   ALTER TABLE ONLY public.appointments
    ADD CONSTRAINT fk95vepu86o8syqtux9gkr71bhy FOREIGN KEY (animal_id) REFERENCES public.animals(id);
 R   ALTER TABLE ONLY public.appointments DROP CONSTRAINT fk95vepu86o8syqtux9gkr71bhy;
       public          postgres    false    217    3484    219            �           2606    16563 #   animals fkb36lt3kj4mrbdx5btxmp4j60n    FK CONSTRAINT     �   ALTER TABLE ONLY public.animals
    ADD CONSTRAINT fkb36lt3kj4mrbdx5btxmp4j60n FOREIGN KEY (customer_id) REFERENCES public.customers(id);
 M   ALTER TABLE ONLY public.animals DROP CONSTRAINT fkb36lt3kj4mrbdx5btxmp4j60n;
       public          postgres    false    217    3488    221            �           2606    16568 1   doctor_available_days fkhhnbfqustrh46vuehatdsv53r    FK CONSTRAINT     �   ALTER TABLE ONLY public.doctor_available_days
    ADD CONSTRAINT fkhhnbfqustrh46vuehatdsv53r FOREIGN KEY (doctor_id) REFERENCES public.doctors(id);
 [   ALTER TABLE ONLY public.doctor_available_days DROP CONSTRAINT fkhhnbfqustrh46vuehatdsv53r;
       public          postgres    false    3496    225    223            �           2606    16573 +   animal_vaccines fkiwvg30h9kqewspm3hj6xl2kn9    FK CONSTRAINT     �   ALTER TABLE ONLY public.animal_vaccines
    ADD CONSTRAINT fkiwvg30h9kqewspm3hj6xl2kn9 FOREIGN KEY (animal_id) REFERENCES public.animals(id);
 U   ALTER TABLE ONLY public.animal_vaccines DROP CONSTRAINT fkiwvg30h9kqewspm3hj6xl2kn9;
       public          postgres    false    215    217    3484            �           2606    16578 (   appointments fkmujeo4tymoo98cmf7uj3vsv76    FK CONSTRAINT     �   ALTER TABLE ONLY public.appointments
    ADD CONSTRAINT fkmujeo4tymoo98cmf7uj3vsv76 FOREIGN KEY (doctor_id) REFERENCES public.doctors(id);
 R   ALTER TABLE ONLY public.appointments DROP CONSTRAINT fkmujeo4tymoo98cmf7uj3vsv76;
       public          postgres    false    225    3496    219            �           2606    16583 *   animal_vaccines fktx6d054a6qgimiblyxm4f5ue    FK CONSTRAINT     �   ALTER TABLE ONLY public.animal_vaccines
    ADD CONSTRAINT fktx6d054a6qgimiblyxm4f5ue FOREIGN KEY (vaccine_id) REFERENCES public.vaccines(id);
 T   ALTER TABLE ONLY public.animal_vaccines DROP CONSTRAINT fktx6d054a6qgimiblyxm4f5ue;
       public          postgres    false    215    227    3500            B   P   x�=M��0z�.�;G�K���!r+�@``���buC�%�h��&!L�Jo��N���pv=�bB�g��܋���|.�/���      D   �   x�=α�0����]j���8���i�P�6_�g`w���䦻/�� !qFz��B�
���pJ�z[�̀UU�G�9�l��������]�_
�s}�ݭ�j�M~wUHK��O�Q�h��\뺃Y^?o���`��L��G�7ڌ��v�r���C6      F   O   x�U���0���
7�;'R��K��F���l��sE|�Pl�s�qSw������T4�C�i8g�e����w      H   }   x�5�1�0@�z�0
�� 4��H&1qv� ��2LM���@��*X])L����Rh�[��*\�{,ћ�zl+Pr$;A�'�[&v�����y�r����ux���SbH�~��3iq<!���9U      J   3   x�EǷ  ����#a���������Υ�[-$��(^��|����      L   |   x�}ʽ�0���)� "�	I�A�\�S�d,dC�,DM��`d����5I�,>l>{��⸼�����(OX�o��8����3��t#�áI'ӓiTq�t�5Xs%ۨ����VO4wD�Z�H=      N   J   x�3�400��<�\!��ƣ�
��2K��8�8��?�ѐ����1�2rL c.S ��1����� �     