-- users
CREATE TABLE "users"
(
	"user_id"      SERIAL    NOT NULL, -- user_id
	"id"           VARCHAR   NULL,     -- id
	"name"         VARCHAR   NULL,     -- name
	"email"        VARCHAR   NULL,     -- email
	"secret"       VARCHAR   NULL,     -- secret
	"created_date" TIMESTAMP NULL,     -- created_date
	"updated_date" TIMESTAMP NULL,     -- updated_date
	"deleted_date" TIMESTAMP NULL      -- deleted_date
);

-- users
COMMENT ON TABLE "users" IS 'users';

-- user_id
COMMENT ON COLUMN "users"."user_id" IS 'user_id';

-- id
COMMENT ON COLUMN "users"."id" IS 'id';

-- name
COMMENT ON COLUMN "users"."name" IS 'name';

-- email
COMMENT ON COLUMN "users"."email" IS 'email';

-- secret
COMMENT ON COLUMN "users"."secret" IS 'secret';

-- created_date
COMMENT ON COLUMN "users"."created_date" IS 'created_date';

-- updated_date
COMMENT ON COLUMN "users"."updated_date" IS 'updated_date';

-- deleted_date
COMMENT ON COLUMN "users"."deleted_date" IS 'deleted_date';

-- user_log
CREATE TABLE "user_log"
(
	"user_log_id"  SERIAL    NOT NULL, -- user_log_id
	"login_date"   TIMESTAMP NULL,     -- login_date
	"login_status" CHAR(1)   NULL,     -- login_status
	"user_id"      BIGINT    NULL      -- user_id
);

-- user_log
COMMENT ON TABLE "user_log" IS 'user_log';

-- user_log_id
COMMENT ON COLUMN "user_log"."user_log_id" IS 'user_log_id';

-- login_date
COMMENT ON COLUMN "user_log"."login_date" IS 'login_date';

-- login_status
COMMENT ON COLUMN "user_log"."login_status" IS 'login_status';

-- user_id
COMMENT ON COLUMN "user_log"."user_id" IS 'user_id';

-- tokens
CREATE TABLE "tokens"
(
	"token_id"      SERIAL    NOT NULL, -- token_id
	"refresh_token" VARCHAR   NULL,     -- refresh_token
	"ip_address"    VARCHAR   NULL,     -- ip_address
	"created_date"  TIMESTAMP NULL,     -- created_date
	"updated_date"  TIMESTAMP NULL,     -- modify_date
	"deleted_date"  TIMESTAMP NULL,     -- deleted_date
	"user_id"       BIGINT    NULL      -- user_id
);

-- tokens
COMMENT ON TABLE "tokens" IS 'tokens';

-- token_id
COMMENT ON COLUMN "tokens"."token_id" IS 'token_id';

-- refresh_token
COMMENT ON COLUMN "tokens"."refresh_token" IS 'refresh_token';

-- ip_address
COMMENT ON COLUMN "tokens"."ip_address" IS 'ip_address';

-- created_date
COMMENT ON COLUMN "tokens"."created_date" IS 'created_date';

-- modify_date
COMMENT ON COLUMN "tokens"."updated_date" IS 'modify_date';

-- deleted_date
COMMENT ON COLUMN "tokens"."deleted_date" IS 'deleted_date';

-- user_id
COMMENT ON COLUMN "tokens"."user_id" IS 'user_id';

-- sns_info
CREATE TABLE "sns_info"
(
	"sns_id"           SERIAL    NOT NULL, -- sns_id
	"id"               VARCHAR   NULL,     -- id
	"sns_type"         VARCHAR   NULL,     -- sns_type
	"sns_name"         VARCHAR   NULL,     -- sns_name
	"sns_profile"      VARCHAR   NULL,     -- sns_profile
	"sns_connect_date" TIMESTAMP NULL,     -- sns_connect_date
	"user_id"          BIGINT    NULL      -- user_id
);

-- sns_info
COMMENT ON TABLE "sns_info" IS 'sns_info';

-- sns_id
COMMENT ON COLUMN "sns_info"."sns_id" IS 'sns_id';

-- id
COMMENT ON COLUMN "sns_info"."id" IS 'id';

-- sns_type
COMMENT ON COLUMN "sns_info"."sns_type" IS 'sns_type';

-- sns_name
COMMENT ON COLUMN "sns_info"."sns_name" IS 'sns_name';

-- sns_profile
COMMENT ON COLUMN "sns_info"."sns_profile" IS 'sns_profile';

-- sns_connect_date
COMMENT ON COLUMN "sns_info"."sns_connect_date" IS 'sns_connect_date';

-- user_id
COMMENT ON COLUMN "sns_info"."user_id" IS 'user_id';

-- anonymous
CREATE TABLE "anonymous"
(
	"anoymous_id"  SERIAL    NOT NULL, -- anonymous_id
	"name"         VARCHAR   NULL,     -- name
	"secret"       VARCHAR   NULL,     -- secret
	"created_date" TIMESTAMP NULL,     -- created_date
	"updated_date" TIMESTAMP NULL,     -- updated_date
	"deleted_date" TIMESTAMP NULL      -- deleted_date
);

-- anonymous
COMMENT ON TABLE "anonymous" IS 'anonymous';

-- anoymous_id
COMMENT ON COLUMN "anonymous"."anoymous_id" IS 'anoymous_id';

-- name
COMMENT ON COLUMN "anonymous"."name" IS 'name';

-- secret
COMMENT ON COLUMN "anonymous"."secret" IS 'secret';

-- created_date
COMMENT ON COLUMN "anonymous"."created_date" IS 'created_date';

-- updated_date
COMMENT ON COLUMN "anonymous"."updated_date" IS 'updated_date';

-- deleted_date
COMMENT ON COLUMN "anonymous"."deleted_date" IS 'deleted_date';

-- board
CREATE TABLE "board"
(
	"board_id"     SERIAL  NOT NULL, -- board_id
	"title"        VARCHAR NULL,     -- title
	"content"      TEXT    NULL,     -- content
	"views"        INTEGER NULL,     -- views
	"created_date" DATE    NULL,     -- created_date
	"updated_date" DATE    NULL,     -- updated_date
	"deleted_date" DATE    NULL,     -- deleted_date
	"user_id"      BIGINT  NULL,     -- user_id
	"option_id"    BIGINT  NULL      -- option_id
);

-- board
COMMENT ON TABLE "board" IS 'board';

-- board_id
COMMENT ON COLUMN "board"."board_id" IS 'board_id';

-- title
COMMENT ON COLUMN "board"."title" IS 'title';

-- content
COMMENT ON COLUMN "board"."content" IS 'content';

-- views
COMMENT ON COLUMN "board"."views" IS 'views';

-- created_date
COMMENT ON COLUMN "board"."created_date" IS 'created_date';

-- updated_date
COMMENT ON COLUMN "board"."updated_date" IS 'updated_date';

-- deleted_date
COMMENT ON COLUMN "board"."deleted_date" IS 'deleted_date';

-- user_id
COMMENT ON COLUMN "board"."user_id" IS 'user_id';

-- option_id
COMMENT ON COLUMN "board"."option_id" IS 'option_id';

-- comment
CREATE TABLE "comment"
(
	"comment_id"   SERIAL NOT NULL, -- comment_id
	"content"      TEXT   NULL,     -- content
	"created_date" DATE   NULL,     -- created_date
	"updated_date" DATE   NULL,     -- updated_date
	"deleted_date" DATE   NULL,     -- deleted_date
	"user_id"      BIGINT NOT NULL, -- user_id
	"board_id"     BIGINT NULL      -- board_id
);

-- comment
COMMENT ON TABLE "comment" IS 'comment';

-- comment_id
COMMENT ON COLUMN "comment"."comment_id" IS 'comment_id';

-- content
COMMENT ON COLUMN "comment"."content" IS 'content';

-- created_date
COMMENT ON COLUMN "comment"."created_date" IS 'created_date';

-- updated_date
COMMENT ON COLUMN "comment"."updated_date" IS 'updated_date';

-- deleted_date
COMMENT ON COLUMN "comment"."deleted_date" IS 'deleted_date';

-- user_id
COMMENT ON COLUMN "comment"."user_id" IS 'user_id';

-- board_id
COMMENT ON COLUMN "comment"."board_id" IS 'board_id';

-- board_likes
CREATE TABLE "board_likes"
(
	"board_likes_id" SERIAL  NOT NULL, -- board_likes_id
	"likes"          INTEGER NULL,     -- likes
	"dislikes"       INTEGER NULL,     -- dislikes
	"user_id"        BIGINT  NULL,     -- user_id
	"board_id"       BIGINT  NULL      -- board_id
);

-- board_likes
COMMENT ON TABLE "board_likes" IS 'board_likes';

-- board_likes_id
COMMENT ON COLUMN "board_likes"."board_likes_id" IS 'board_likes_id';

-- likes
COMMENT ON COLUMN "board_likes"."likes" IS 'likes';

-- dislikes
COMMENT ON COLUMN "board_likes"."dislikes" IS 'dislikes';

-- user_id
COMMENT ON COLUMN "board_likes"."user_id" IS 'user_id';

-- board_id
COMMENT ON COLUMN "board_likes"."board_id" IS 'board_id';

-- restaurant
CREATE TABLE "restaurant"
(
	"restaurant_id" SERIAL  NOT NULL, -- restaurant_id
	"name"          VARCHAR NULL,     -- name
	"created_date"  DATE    NULL,     -- created_date
	"updated_date"  DATE    NULL,     -- updated_date
	"deleted_date"  DATE    NULL,     -- deleted_date
	"address"       VARCHAR NULL,     -- address
	"lng"           FLOAT4  NULL,     -- lng
	"lat"           FLOAT4  NULL,     -- lat
	"option_id"     BIGINT  NULL,     -- option_id
	"board_id"      BIGINT  NULL      -- board_id
);

-- restaurant
COMMENT ON TABLE "restaurant" IS 'restaurant';

-- restaurant_id
COMMENT ON COLUMN "restaurant"."restaurant_id" IS 'restaurant_id';

-- name
COMMENT ON COLUMN "restaurant"."name" IS 'name';

-- created_date
COMMENT ON COLUMN "restaurant"."created_date" IS 'created_date';

-- updated_date
COMMENT ON COLUMN "restaurant"."updated_date" IS 'updated_date';

-- deleted_date
COMMENT ON COLUMN "restaurant"."deleted_date" IS 'deleted_date';

-- address
COMMENT ON COLUMN "restaurant"."address" IS 'address';

-- lng
COMMENT ON COLUMN "restaurant"."lng" IS 'lng';

-- lat
COMMENT ON COLUMN "restaurant"."lat" IS 'lat';

-- option_id
COMMENT ON COLUMN "restaurant"."option_id" IS 'option_id';

-- board_id
COMMENT ON COLUMN "restaurant"."board_id" IS 'board_id';

-- option
CREATE TABLE "option"
(
	"option_id"    SERIAL  NOT NULL, -- option_id
	"level"        INT     NULL,     -- level
	"order"        INT     NULL,     -- order
	"description"  VARCHAR NULL,     -- description
	"created_date" DATE    NULL,     -- created_date
	"updated_date" DATE    NULL,     -- updated_date
	"deleted_date" DATE    NULL,     -- deleted_date
	"p_option_id"  BIGINT  NULL      -- p_option_id
);

-- option
COMMENT ON TABLE "option" IS 'option';

-- option_id
COMMENT ON COLUMN "option"."option_id" IS 'option_id';

-- level
COMMENT ON COLUMN "option"."level" IS 'level';

-- order
COMMENT ON COLUMN "option"."order" IS 'order';

-- description
COMMENT ON COLUMN "option"."description" IS 'description';

-- created_date
COMMENT ON COLUMN "option"."created_date" IS 'created_date';

-- updated_date
COMMENT ON COLUMN "option"."updated_date" IS 'updated_date';

-- deleted_date
COMMENT ON COLUMN "option"."deleted_date" IS 'deleted_date';

-- p_option_id
COMMENT ON COLUMN "option"."p_option_id" IS 'p_option_id';

-- menu
CREATE TABLE "menu"
(
	"menu_id"       SERIAL  NOT NULL, -- menu_id
	"name"          VARCHAR NULL,     -- name
	"price"         INT     NULL,     -- price
	"option_id"     BIGINT  NULL,     -- option_id
	"restaurant_id" BIGINT  NULL      -- restaurant_id
);

-- menu
COMMENT ON TABLE "menu" IS 'menu';

-- menu_id
COMMENT ON COLUMN "menu"."menu_id" IS 'menu_id';

-- name
COMMENT ON COLUMN "menu"."name" IS 'name';

-- price
COMMENT ON COLUMN "menu"."price" IS 'price';

-- option_id
COMMENT ON COLUMN "menu"."option_id" IS 'option_id';

-- restaurant_id
COMMENT ON COLUMN "menu"."restaurant_id" IS 'restaurant_id';

-- restaurant_blog
CREATE TABLE "restaurant_blog"
(
	"blog_id"       SERIAL  NOT NULL, -- blog_id
	"url"           VARCHAR NULL,     -- url
	"board_title"   VARCHAR NULL,     -- board_title
	"restaurant_id" BIGINT  NULL      -- restaurant_id
);

-- restaurant_blog
COMMENT ON TABLE "restaurant_blog" IS 'restaurant_blog';

-- blog_id
COMMENT ON COLUMN "restaurant_blog"."blog_id" IS 'blog_id';

-- url
COMMENT ON COLUMN "restaurant_blog"."url" IS 'url';

-- board_title
COMMENT ON COLUMN "restaurant_blog"."board_title" IS 'board_title';

-- restaurant_id
COMMENT ON COLUMN "restaurant_blog"."restaurant_id" IS 'restaurant_id';

-- user_chat
CREATE TABLE "user_chat"
(
	"chat_id" BIGINT NULL, -- chat_id
	"user_id" BIGINT NULL  -- user_id
);

-- user_chat
COMMENT ON TABLE "user_chat" IS 'user_chat';

-- chat_id
COMMENT ON COLUMN "user_chat"."chat_id" IS 'chat_id';

-- user_id
COMMENT ON COLUMN "user_chat"."user_id" IS 'user_id';

-- message
CREATE TABLE "message"
(
	"created_date" DATE   NULL, -- created_date
	"message"      TEXT   NULL, -- message
	"user_id"      BIGINT NULL, -- user_id
	"chat_id"      BIGINT NULL  -- chat_id
);

-- message
COMMENT ON TABLE "message" IS 'message';

-- created_date
COMMENT ON COLUMN "message"."created_date" IS 'created_date';

-- message
COMMENT ON COLUMN "message"."message" IS 'message';

-- user_id
COMMENT ON COLUMN "message"."user_id" IS 'user_id';

-- chat_id
COMMENT ON COLUMN "message"."chat_id" IS 'chat_id';

-- chat
CREATE TABLE "chat"
(
	"chat_id"  SERIAL  NOT NULL, -- chat_id
	"topic"    VARCHAR NULL,     -- topic
	"password" VARCHAR NULL      -- password
);

-- chat
COMMENT ON TABLE "chat" IS 'chat';

-- chat_id
COMMENT ON COLUMN "chat"."chat_id" IS 'chat_id';

-- topic
COMMENT ON COLUMN "chat"."topic" IS 'topic';

-- password
COMMENT ON COLUMN "chat"."password" IS 'password';

-- app_logs
CREATE TABLE "app_logs"
(
	"id"           SERIAL  NOT NULL, -- id
	"created_date" DATE    NULL,     -- created_date
	"app_name"     VARCHAR NULL,     -- app_name
	"log_level"    VARCHAR NULL,     -- log_level
	"location"     VARCHAR NULL,     -- location
	"message"      TEXT    NULL,     -- message
	"stack_trace"  TEXT    NULL      -- stack_trace
);

-- app_logs
COMMENT ON TABLE "app_logs" IS 'app_logs';

-- id
COMMENT ON COLUMN "app_logs"."id" IS 'id';

-- created_date
COMMENT ON COLUMN "app_logs"."created_date" IS 'created_date';

-- app_name
COMMENT ON COLUMN "app_logs"."app_name" IS 'app_name';

-- log_level
COMMENT ON COLUMN "app_logs"."log_level" IS 'log_level';

-- location
COMMENT ON COLUMN "app_logs"."location" IS 'location';

-- message
COMMENT ON COLUMN "app_logs"."message" IS 'message';

-- stack_trace
COMMENT ON COLUMN "app_logs"."stack_trace" IS 'stack_trace';

-- comment_likes
CREATE TABLE "comment_likes"
(
	"comment_likes_id" SERIAL  NOT NULL, -- comment_likes_id
	"likes"            INTEGER NULL,     -- likes
	"dislikes"         INTEGER NULL,     -- dislikes
	"user_id"          BIGINT  NULL,     -- user_id
	"comment_id"       BIGINT  NULL      -- comment_id
);

-- comment_likes
COMMENT ON TABLE "comment_likes" IS 'comment_likes';

-- comment_likes_id
COMMENT ON COLUMN "comment_likes"."comment_likes_id" IS 'comment_likes_id';

-- likes
COMMENT ON COLUMN "comment_likes"."likes" IS 'likes';

-- dislikes
COMMENT ON COLUMN "comment_likes"."dislikes" IS 'dislikes';

-- user_id
COMMENT ON COLUMN "comment_likes"."user_id" IS 'user_id';

-- comment_id
COMMENT ON COLUMN "comment_likes"."comment_id" IS 'comment_id';

-- t_post_group_user
CREATE TABLE "t_post_group_user"
(
	"board_id"     BIGINT NULL, -- board_id
	"user_id"      BIGINT NULL, -- user_id
	"created_date" DATE   NULL, -- created_date
	"updated_date" DATE   NULL, -- updated_date
	"deleted_date" DATE   NULL  -- deleted_date
);

-- t_post_group_user
COMMENT ON TABLE "t_post_group_user" IS 't_post_group_user';

-- board_id
COMMENT ON COLUMN "t_post_group_user"."board_id" IS 'board_id';

-- user_id
COMMENT ON COLUMN "t_post_group_user"."user_id" IS 'user_id';

-- created_date
COMMENT ON COLUMN "t_post_group_user"."created_date" IS 'created_date';

-- updated_date
COMMENT ON COLUMN "t_post_group_user"."updated_date" IS 'updated_date';

-- deleted_date
COMMENT ON COLUMN "t_post_group_user"."deleted_date" IS 'deleted_date';

-- t_tag_board
CREATE TABLE "t_tag_board"
(
	"tag_board_id" SERIAL NOT NULL, -- tag_board_id
	"tag_id"       BIGINT NULL,     -- tag_id
	"board_id"     BIGINT NULL,     -- board_id
	"created_date" DATE   NULL,     -- created_date
	"updated_date" DATE   NULL,     -- updated_date
	"deleted_date" DATE   NULL      -- deleted_date
);

-- t_tag_board
COMMENT ON TABLE "t_tag_board" IS 't_tag_board';

-- tag_board_id
COMMENT ON COLUMN "t_tag_board"."tag_board_id" IS 'tag_board_id';

-- tag_id
COMMENT ON COLUMN "t_tag_board"."tag_id" IS 'tag_id';

-- board_id
COMMENT ON COLUMN "t_tag_board"."board_id" IS 'board_id';

-- created_date
COMMENT ON COLUMN "t_tag_board"."created_date" IS 'created_date';

-- updated_date
COMMENT ON COLUMN "t_tag_board"."updated_date" IS 'updated_date';

-- deleted_date
COMMENT ON COLUMN "t_tag_board"."deleted_date" IS 'deleted_date';

-- tags
CREATE TABLE "tags"
(
	"tag_id"       SERIAL  NOT NULL, -- tag_id
	"name"         VARCHAR NULL,     -- name
	"created_date" DATE    NULL      -- created_date
);

-- tags
COMMENT ON TABLE "tags" IS 'tags';

-- tag_id
COMMENT ON COLUMN "tags"."tag_id" IS 'tag_id';

-- name
COMMENT ON COLUMN "tags"."name" IS 'name';

-- created_date
COMMENT ON COLUMN "tags"."created_date" IS 'created_date';

