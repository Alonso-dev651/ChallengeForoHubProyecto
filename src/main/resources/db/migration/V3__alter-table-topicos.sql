ALTER TABLE topicos ADD COLUMN usuario_id bigint;

ALTER TABLE topicos MODIFY COLUMN usuario_id bigint NOT NULL;
ALTER TABLE topicos ADD CONSTRAINT fk_topico_usuario_id FOREIGN KEY (usuario_id) REFERENCES usuarios(id);
