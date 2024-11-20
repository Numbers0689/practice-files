import pic from "./assets/gpt.png"

function Card() {
    return (
    <>
        <div className="cid">
            <img src={pic}></img>
            <h3>ChatGPT</h3>
            <h3>From OpenAI</h3>
        </div>
    </>
    );
}

export default Card;