import axios from "axios";
import { useState } from "react";

function PostForm() {
    const [title, setTitle] = useState('');
    const [content, setContent] = useState('');
    const [writer, setWriter] = useState('');
    const [response, setResponse] = useState(null);

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            const result = await axios.post('http://localhost:8080/post1', {
                title: "안녕",
                content: "바보",
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

export default PostForm;
