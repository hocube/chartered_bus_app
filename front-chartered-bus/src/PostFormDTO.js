import axios from "axios";
import { useState } from "react";

function PostFormDTO() {
    const [response, setResponse] = useState(null);

    const handleSubmit = async () => {
        try {
            const result = await axios.post('http://localhost:8080/post2', {
                title: "이건 PostDTO",
                content: "잘 될까요?",
                writer: "",
            });
            setResponse(result.data);
        } catch (error) {
            if (error.response) {
                setResponse(error.response.data);
            }
        }
    };

    return (
        <div>
            <button onClick={handleSubmit}>실행버튼</button>
            {response && (
                <div>
                    <h2>Response</h2>
                    <pre>{JSON.stringify(response, null, 2)}</pre>
                </div>
            )}
        </div>
    );
}

export default PostFormDTO;
