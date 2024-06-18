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
(define MISSILE-SPEED 10)

(define HIT-RANGE 10)

(define INVADE-RATE 100)

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
;; !!!

;(define (advance-invaders loi) loi) ;stub

(define (advance-invaders loi)
  (cond[(empty? loi) empty]
       [else
        (cons (move-invader (first loi))
              (advance-invaders (rest loi)))]))


;; invader -> invader
;; moves invader and bouces off walls when it reaches the end
;; !!!
(check-expect (move-invader I1) (make-invader ))

;(define (move-invader i) i) ;stub

(define (move-invader invader)
  (... (invader-x invader) (invader-y invader) (invader-dx invader)))


;; loi -> loi
;; create new invaders
;; !!!

(define (create-invaders loi) loi) ;stub
#;
(define (fn-for-loi loi)
  (cond[(empty? loi) (...)]
       [else
        (... (fn-for-invader (first loi))
             (fn-for-loi (rest loi)))]))


;; lom loi -> lom
;; removes invaders hit by missiles
;; !!!

(define (destroy-invaders lom loi) loi) ;stub


;; tank -> tank
;; advances tank based on keyevent
;; !!!

(define (advance-tank t) t) ;stub


;; game -> image
;; render game, the current world
;; !!!

(define (render s) BACKGROUND) ;stub 


;; game key -> game
;; moves the tank left and right, fires missiles
;; !!!

(define (handle-key s ke) (...)) ;stub


;; game -> boolean
;; checks if the game is over
;; !!!

(define (game-over s) false) ;stub
