export default function StatusBar(props) {
    return <div id="status-bar">
        <button disabled={props.currentIndex <= 0} id="prev" onClick={props.prevCallback}>&larr;</button>
        <strong>{props.currentIndex+1}</strong>/<span>{props.maxIndex}</span>
        <button disabled={props.currentIndex >= props.maxIndex-1} id="next" onClick={props.nextCallback}>&rarr;</button>
    </div>;
}