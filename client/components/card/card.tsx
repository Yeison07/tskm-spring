import Image from 'next/image';
import * as React from 'react';
import { SubTitle, Text } from '../text/text';
import styles from './card.module.css';
interface ICardProps {
  card: {
    title: string;
    description: string;
    image?: string;
  };
}

const Card: React.FunctionComponent<ICardProps> = ({ card }) => {
  return (
    <div className={styles.card}>
      <SubTitle>{card.title}</SubTitle>
      <div className={styles.card_content}>
        {card.image ? <Image alt="Logo proyecto" src={card.image} /> : null}
        <Text>{card.description}</Text>
      </div>
    </div>
  );
};

export default Card;
