;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname space-invaders-starter) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
(require 2htdp/universe)
(require 2htdp/image)

;; Space Invaders


;; Constants:

(define WIDTH  300)
(define HEIGHT 500)

(define INVADER-X-SPEED 1.5)  ;speeds (not velocities) in pixels per tick
(define INVADER-Y-SPEED 1.5)
(define TANK-SPEED 2)
(define MISSILE-SPEED 6)

(define HIT-RANGE 10)

(define INVADE-RATE 10)

(define BACKGROUND (empty-scene WIDTH HEIGHT))

(define INVADER
  (overlay/xy (ellipse 10 15 "outline" "blue")              ;cockpit cover
              -5 6
              (ellipse 20 10 "solid"   "blue")))            ;saucer

(define TANK
  (overlay/xy (overlay (ellipse 28 8 "solid" "black")       ;tread center
                       (ellipse 30 10 "solid" "green"))     ;tread outline
              5 -14
              (above (rectangle 5 10 "solid" "black")       ;gun
                     (rectangle 20 10 "solid" "black"))))   ;main body

(define TANK-HEIGHT/2 (/ (image-height TANK) 2))

(define MISSILE (ellipse 5 15 "solid" "red"))



;; Data Definitions:

(define-struct game (invaders missiles tank))
;; Game is (make-game  (listof Invader) (listof Missile) Tank)
;; interp. the current state of a space invaders game
;;         with the current invaders, missiles and tank position

;; Game constants defined below Missile data definition

#;
(define (fn-for-game s)
  (... (fn-for-loinvader (game-invaders s))
       (fn-for-lom (game-missiles s))
       (fn-for-tank (game-tank s))))



(define-struct tank (x dir))
;; Tank is (make-tank Number Integer[-1, 1])
;; interp. the tank location is x, HEIGHT - TANK-HEIGHT/2 in screen coordinates
;;         the tank moves TANK-SPEED pixels per clock tick left if dir -1, right if dir 1

(define T0 (make-tank (/ WIDTH 2) 1))   ;center going right
(define T1 (make-tank 50 1))            ;going right
(define T2 (make-tank 50 -1))           ;going left

#;
(define (fn-for-tank t)
  (... (tank-x t) (tank-dir t)))



(define-struct invader (x y dx))
;; Invader is (make-invader Number Number Number)
;; interp. the invader is at (x, y) in screen coordinates
;;         the invader along x by dx pixels per clock tick

(define I1 (make-invader 150 100 12))           ;not landed, moving right
(define I2 (make-invader 150 HEIGHT -10))       ;exactly landed, moving left
(define I3 (make-invader 150 (+ HEIGHT 10) 10)) ;> landed, moving right


#;
(define (fn-for-invader invader)
  (... (invader-x invader) (invader-y invader) (invader-dx invader)))


(define-struct missile (x y))
;; Missile is (make-missile Number Number)
;; interp. the missile's location is x y in screen coordinates

(define M1 (make-missile 150 300))                       ;not hit U1
(define M2 (make-missile (invader-x I1) (+ (invader-y I1) 10)))  ;exactly hit U1
(define M3 (make-missile (invader-x I1) (+ (invader-y I1)  5)))  ;> hit U1

#;
(define (fn-for-missile m)
  (... (missile-x m) (missile-y m)))



(define G0 (make-game empty empty T0))
(define G1 (make-game empty empty T1))
(define G2 (make-game (list I1) (list M1) T1))
(define G3 (make-game (list I1 I2) (list M1 M2) T1))

;; ListOfMissiles is one of:
;; - empty
;; - (cons missile ListOfMissiles)
;; interp. list of missiles in the game

(define LOM1 empty)
(define LOM2 (list M1))
(define LOM3 (list M1 M2 M3))

#;
(define (fn-for-lom lom)
  (cond[(empty? lom) (...)]
       [else
        (... (fn-for-missile (first lom))
             (fn-for-lom (rest lom)))]))

;; ListOfIvaders is one of:
;; - empty
;; - (cons invader ListOfInvaders)
;; interp. list of invaders in the game

(define LOI1 empty)
(define LOI2 (list I1))
(define LOI3 (list I1 I2 I3))

#;
(define (fn-for-loi loi)
  (cond[(empty? loi) (...)]
       [else
        (... (fn-for-invader (first loi))
             (fn-for-loi (rest loi)))]))

;; FUNCTIONS

;; 
;; start game with (main 0)

(define (main s)
  (big-bang
      (make-game empty empty (make-tank (/ WIDTH 2) s))
    (on-tick advance-game)
    (to-draw render)
    (on-key handle-key)
    (stop-when game-over)))

;; game -> game
;; advances game:
;;  - moves tank, missiles, invaders
;;  - creates new invaders

(define (advance-game s)
  (make-game (destroy-invaders (game-missiles s) (create-invaders (advance-invaders (game-invaders s))))
             (advance-missiles (game-missiles s))
             (advance-tank (game-tank s))))
 

;; lom -> lom
;; advances missiles at speed per tick

;(define (advance-missiles lom) lom) ;stub
(check-expect (advance-missiles empty) empty)
(check-expect (advance-missiles LOM2) (cons (make-missile 150 (- 300 MISSILE-SPEED)) empty))

(define (advance-missiles lom)
  (cond [(empty? lom) empty]
        [else
         (if (< (missile-y (first lom)) 0)
             (advance-missiles (rest lom))
             (cons (move-missile (first lom))
                   (advance-missiles (rest lom))))]))

;; missile -> missile
;; moves missile at speed per tick
(check-expect (move-missile M1) (make-missile 150 (- 300 MISSILE-SPEED)))

;(define (move-missile m) m) ;stub

(define (move-missile m)
  (make-missile (missile-x m) ( - (missile-y m) MISSILE-SPEED)))


;; loi -> loi
;; advances invaders at invaders rate per tick

;(define (advance-invaders loi) loi) ;stub

(define (advance-invaders loi)
  (cond[(empty? loi) empty]
       [else
        (cons (move-invader (first loi))
              (advance-invaders (rest loi)))]))


;; invader -> invader
;; moves invader and bouces off walls when it reaches the end

;(define (move-invader i) i) ;stub

(define (move-invader i)
  (cond[(< (+ (invader-x i) (* (invader-dx i) INVADER-X-SPEED)) 0)
        (make-invader 0 (+ (invader-y i) INVADER-Y-SPEED) (- (invader-dx i)))]
       [(> (+ (invader-x i) (* (invader-dx i) INVADER-X-SPEED)) WIDTH)
        (make-invader WIDTH (+ (invader-y i) INVADER-Y-SPEED) (- (invader-dx i)))]
       [else
        (make-invader (+ (invader-x i) (* INVADER-X-SPEED (invader-dx i))) (+ (invader-y i) INVADER-Y-SPEED) (invader-dx i))]))


;; loi -> loi
;; create new invaders
;; !!!

;(define (create-invaders loi) loi) ;stub

(define (create-invaders loi)
  (cond[(< (random 150) INVADE-RATE)
        (cons (make-invader (random WIDTH) 0 (random-direction 1)) loi)]
       [else loi]))

;; Integer -> Integer
;; Given an integer, return the negative or positive value of the integer randomly

;(define (random-direction i) i)

(define (random-direction i)
  (if (= (modulo (random 10) 2) 1)
      (- i)
      i))


;; lom loi -> lom
;; removes invaders hit by missiles
;; !!!

;(define (destroy-invaders lom loi) loi) ;stub

(define (destroy-invaders lom loi)
  (cond[(empty? loi) empty]
       [(empty? lom) loi]
       [else
        (if (find-invader (first loi) lom)
            (rest loi)
            (cons (first loi) (destroy-invaders lom (rest loi))))]))

;; Invader ListOfMissile -> Boolean
;; if the invaders x and y position is found within the hitbox of the missile, return true

;(define (find-invader i lom) false)

(define (find-invader i lom)
  (cond[(empty? lom) false]
       [else
        (if (and (< (- (invader-x i) HIT-RANGE) (missile-x (first lom)) (+ (invader-x i) HIT-RANGE))
                 (< (- (invader-y i) HIT-RANGE) (missile-y (first lom)) (+ (invader-y i) HIT-RANGE)))
            true
            (find-invader i (rest lom)))]))


;; tank -> tank
;; advances tank based on keyevent
;; !!!

;(define (advance-tank t) t) ;stub

(define (advance-tank t)
  (cond[(> (tank-x t) WIDTH)
        (make-tank WIDTH 0)]
       [(< (tank-x t) 0)
        (make-tank 0 0)]
       [else
        (make-tank (+ (tank-x t) (* (tank-dir t) TANK-SPEED)) (tank-dir t))]))


;; game -> image
;; render game, the current world
;; !!!

;(define (render s) BACKGROUND) ;stub

(define (render s)
  (render-invaders (game-invaders s)
                   (render-missiles (game-missiles s)
                                    (render-tank (game-tank s)))))

;; Tank -> Image
;; produce the image of a tank on BACKGROUND
(check-expect (render-tank (make-tank (/ WIDTH 2) 0)) (place-image TANK (/ WIDTH 2) (- HEIGHT TANK-HEIGHT/2) BACKGROUND)) 

;(define (render-tank t) BACKGROUND) ;stub

(define (render-tank t)
  (place-image TANK (tank-x t) (- HEIGHT TANK-HEIGHT/2) BACKGROUND))

;; ListOfMissile Image -> Image
;; draws the list of invaders onto Image input

;(define (render-missiles lom img) img)

(define (render-missiles lom img)
  (cond[(empty? lom) img]
       [else
        (place-image MISSILE
                     (missile-x (first lom))
                     (missile-y (first lom))
                     (render-missiles (rest lom) img))]))


;; ListOfInvader Image -> Image
;; draws the list of invaders ont the Image input

;(define (render-invaders loi img) img)

(define (render-invaders loi img)
  (cond[(empty? loi) img]
       [else
        (place-image INVADER
                     (invader-x (first loi))
                     (invader-y (first loi))
                     (render-invaders (rest loi) img))]))

;; Game -> Boolean
;; returns true when the game has ended: when an invader has reached the bottom of the screen


;(define (game-over s) false)

(define (game-over s)
  (cond[(empty? (game-invaders s)) false]
       [else
        (landed (game-invaders s))]))

;; Game -> Image
;; produce the game over screen

;(define (gos s) BACKGROUND)

(define (gos s)
  (place-image (text "GAME-OVER" 45 "black") (/ WIDTH 2) (/ HEIGHT 2) (render s)))

;; ListOfInvader -> Boolean
;; produces true if an invader has LANDED!!

;(define (landed i) false) ;stub

(define (landed loi)
  (cond[(empty? loi) false]
       [else
        (if (>= (invader-y (first loi)) HEIGHT)
            true
            (landed (rest loi)))]))

;; Game KeyEvent -> Game
;; - left and right keys change the direction of the tank
;; - space bar fires missiles from the tank

;(define (handle-key s ke) s)

(define (handle-key s ke)
  (cond [(key=? ke " ") (make-game (game-invaders s) (fire-missile (game-missiles s) (tank-x (game-tank s))) (game-tank s))]
        [(key=? ke "left") (make-game (game-invaders s) (game-missiles s) (turn-left (game-tank s)))]
        [(key=? ke "right") (make-game (game-invaders s) (game-missiles s) (turn-right (game-tank s)))]
        [else 
         s]))

;; ListOfMissile Natural -> ListOfMissile
;; fires a missile
(check-expect (fire-missile empty 150) (cons (make-missile 150 (- HEIGHT TANK-HEIGHT/2)) empty))

;(define (fire-missile lom x) lom)

(define (fire-missile lom x)
  (cond[(empty? lom) (cons (make-missile x (- HEIGHT TANK-HEIGHT/2)) empty)]
       [else
        (cons (make-missile x (- HEIGHT TANK-HEIGHT/2)) lom)]))

;; Tank -> Tank
;; turns the tank left

;(define (turn-left t) t)

(define (turn-left t)
  (make-tank (tank-x t) -1))

;; Tank -> Tank
;; turns the tank right

;(define (turn-right t) t)

(define (turn-right t)
  (make-tank (tank-x t) 1))
