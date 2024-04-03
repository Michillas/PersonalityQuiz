-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-04-2024 a las 11:08:42
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `personalityquiz`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `admin`
--

INSERT INTO `admin` (`id`, `name`, `password`) VALUES
(1, 'test', '$2a$10$bPVucNQCOL0OkGI/sk3wLOSdDiigecHXtcrYnwGvDQ0ouiF9LMgD2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `character`
--

CREATE TABLE `character` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `mbti` varchar(255) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `character`
--

INSERT INTO `character` (`id`, `name`, `mbti`, `img`) VALUES
(1, 'Calamardo', 'ISTJ', 'https://static1.personality-database.com/profile_images/302f4a4720734ea1ad78c97ac2985816.png'),
(2, 'Darth Vader', 'ISTJ', 'https://static1.personality-database.com/profile_images/f1202cd4411c490d8edb69a1b157e01e.png'),
(3, 'Mikasa Ackerman', 'ISTJ', 'https://static1.personality-database.com/profile_images/53b28326337d406396282df1d5fcbe7e.png'),
(4, 'Capitan America', 'ISFJ', 'https://static1.personality-database.com/profile_images/daca144a491b48a8936b9bd03484e0d6.png'),
(5, 'Morty', 'ISFJ', 'https://static1.personality-database.com/profile_images/bec0e54423074f03bde21b7348f539ea.png'),
(6, 'Marge Simpson', 'ISFJ', 'https://static1.personality-database.com/profile_images/568dc6f8f1f44609b85989af6d716275.png'),
(7, 'Luffy', 'ESFP', 'https://static1.personality-database.com/profile_images/99d89f6bed014d16855bfd882efee0f2.png'),
(8, 'Jesse Pinkman', 'ESFP', 'https://static1.personality-database.com/profile_images/558f763dcfcd4ab1a29ac9244ac62e4d.png'),
(9, 'Cristiano Ronaldo', 'ESFP', 'https://static1.personality-database.com/profile_images/c0234fe4fafc4fb39e99f41a3f237a34.png'),
(10, 'Thor', 'ESTP', 'https://static1.personality-database.com/profile_images/1e7c266f4a3148478ed571f1a6558a65.png'),
(11, 'El gato con botas', 'ESTP', 'https://static1.personality-database.com/profile_images/cce963f299964bea8caa63581768bb08.png'),
(12, 'Zero Two', 'ESTP', 'https://static1.personality-database.com/profile_images/0ed088653fa4465983eee4610782e13e.png'),
(13, 'Loki', 'INFJ', 'https://static1.personality-database.com/profile_images/4b4e5f0c55da4fb2ac75dd0b8804741b.png'),
(14, 'Itachi', 'INFJ', 'https://static1.personality-database.com/profile_images/a518b2184fc64c31878886cf8727525d.png'),
(15, 'Isagi Yoichi', 'INFJ', 'https://static1.personality-database.com/profile_images/44a37bcf1008441d90018c656205b09a.png'),
(16, 'Darwin', 'INFP', 'https://static1.personality-database.com/profile_images/26c07cc506c9471ea28c3da5b97ffedd.png'),
(17, 'Kaneki', 'INFP', 'https://static1.personality-database.com/profile_images/42c53f5b4a4e4a0db031e8adf060655e.png'),
(18, 'Johnny Depp', 'INFP', 'https://static1.personality-database.com/profile_images/7cb400b46cb04292b6fa726424a81170.png'),
(19, 'L', 'INTP', 'https://static1.personality-database.com/profile_images/2937ef8b276e4d0aaf20d5f9f2e2a5a1.png'),
(20, 'Sherlock Holmes', 'INTP', 'https://static1.personality-database.com/profile_images/29d2d695e99c47e69ff65a1ffa76e40c.png'),
(21, 'Dipper Pines', 'INTP', 'https://static1.personality-database.com/profile_images/5ffca5156f844e81969f603e08931a19.png'),
(22, 'Elon Musk', 'INTJ', 'https://static1.personality-database.com/profile_images/3b610d12ac8b484182f13aa203daa2dc.png'),
(23, 'Walter White', 'INTJ', 'https://static1.personality-database.com/profile_images/7160a84dd745441d92599d44a0282d17.png'),
(24, 'Thanos', 'INTJ', 'https://static1.personality-database.com/profile_images/c815f33102a74f89b6456a2789697460.png'),
(25, 'Hermione', 'ESTJ', 'https://static1.personality-database.com/profile_images/a08308727fa443b4af8257f16481f2a8.png'),
(26, 'Vegeta', 'ESTJ', 'https://static1.personality-database.com/profile_images/c986e8160ef74b7cba81ab1987a2f2d0.png'),
(27, 'Mr Cangrejo', 'ESTJ', 'https://static1.personality-database.com/profile_images/c64e3d80df204611a1dd84035bef8c6e.png'),
(31, 'Taylor Swift', 'ESFJ', 'https://static1.personality-database.com/profile_images/3b5545342050425b9e3a31e05849bf58.png'),
(32, 'Historia', 'ESFJ', 'https://static1.personality-database.com/profile_images/3d5ba5acd0014b7fb1d0f931bf445538.png'),
(33, 'Steven Universe', 'ESFJ', 'https://static1.personality-database.com/profile_images/050b277aa5dd43849fbcb7628a4fbec0.png'),
(34, 'Sasuke Uchiha', 'ISFP', 'https://static1.personality-database.com/profile_images/d86dc03729ba46f6953a092435ebeb17.png'),
(35, 'Harry Potter', 'ISFP', 'https://static1.personality-database.com/profile_images/1e7e6fac3bda49a38e1844b730345f4a.png'),
(36, 'Once', 'ISFP', 'https://static1.personality-database.com/profile_images/05397679645240b5a1f924805fbbf967.png'),
(37, 'Sherk', 'ISTP', 'https://static1.personality-database.com/profile_images/ec7d41ac0a7d40c4a5edbf26bdb0ace8.png'),
(38, 'Zoro', 'ISTP', 'https://static1.personality-database.com/profile_images/cf7d54000be54fa9b1122f4293cb00f5.png'),
(39, 'Eminem', 'ISTP', 'https://static1.personality-database.com/profile_images/fe73cdfe89ae4049814b84d51c9a83ea.png'),
(40, 'Homelander', 'ENFJ', 'https://static1.personality-database.com/profile_images/83009ff58a6644058e8e1259f78cc70b.png'),
(41, 'Makima', 'ENFJ', 'https://static1.personality-database.com/profile_images/eb793d4c788f497b8bf3991494185126.png'),
(42, 'Drake', 'ENFJ', 'https://static1.personality-database.com/profile_images/c78eae5142d04628a1d17a62da62dc17.png'),
(43, 'Naruto', 'ENFP', 'https://static1.personality-database.com/profile_images/f9463d9a484f43d7a5c21c3a1c4ac066.png'),
(44, 'Aang', 'ENFP', 'https://static1.personality-database.com/profile_images/2ac9b5b2362149a58d03751c763eb4ec.png'),
(45, 'Rapunzel', 'ENFP', 'https://static1.personality-database.com/profile_images/b6dd2d8e316f4a97be68e4abd21c17d5.png'),
(46, 'Gojo', 'ENTP', 'https://static1.personality-database.com/profile_images/e605ec5a80fd45ea8aed4d1cdbff1817.png'),
(47, 'Tony Stark', 'ENTP', 'https://static1.personality-database.com/profile_images/47fbd53c7a54432e868e1993c30a2e6c.png'),
(48, 'Rick', 'ENTP', 'https://static1.personality-database.com/profile_images/1f0f2eff7eda4641bdd59745b1eba54f.png'),
(49, 'Light', 'ENTJ', 'https://static1.personality-database.com/profile_images/2423f38d40b14c2cb6ee54da931ce4b1.png'),
(50, 'Thomas Shelby', 'ENTJ', 'https://static1.personality-database.com/profile_images/2b795be4abcc4515bebef8a7321095e8.png'),
(51, 'Steve Jobs', 'ENTJ', 'https://static1.personality-database.com/profile_images/669709e2793c48bc9dcd23686e4de73a.png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mbti`
--

CREATE TABLE `mbti` (
  `id` int(11) NOT NULL,
  `mbti` varchar(4) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `mbti`
--

INSERT INTO `mbti` (`id`, `mbti`, `name`, `description`) VALUES
(1, 'ISTJ', 'Logista', 'Los ISTJ son prácticos y meticulosos, conocidos como \"Logistas\", que valoran la tradición y la responsabilidad. Son reservados y serios, prefiriendo trabajar solos y en un ambiente estructurado donde puedan aplicar sus habilidades analíticas.'),
(2, 'ISFJ', 'Defensor', 'Los ISFJ son serviciales y dedicados, conocidos como \"Defensores\", que se preocupan profundamente por los demás. Son pacientes y responsables, disfrutando de las tareas prácticas que les permiten ayudar a los que los rodean.'),
(3, 'INFJ', 'Abogado', 'Los INFJ son visionarios y compasivos, conocidos como \"Abogados\", que se esfuerzan por entender a los demás y ayudar en su desarrollo personal. Son idealistas y creativos, con una profunda integridad y un enfoque en el crecimiento espiritual.'),
(4, 'INTJ', 'Arquitecto', 'Los INTJ son estratégicos y analíticos, conocidos como \"Arquitectos\", que buscan comprender y mejorar el mundo que los rodea. Son independientes y visionarios, enfocados en el logro de sus objetivos a largo plazo con un enfoque en la eficiencia y la innovación.'),
(5, 'ISTP', 'Virtuoso', 'Los ISTP son pragmáticos y audaces, conocidos como \"Virtuosos\", que disfrutan explorando cómo funcionan las cosas y resolviendo problemas prácticos. Son ingeniosos y reservados, prefiriendo aprender a través de la experiencia directa y la experimentación.'),
(6, 'ISFP', 'Aventurero', 'Los ISFP son sensibles y libres de espíritu, conocidos como \"Aventureros\", que disfrutan explorando el mundo a través de sus sentidos y experiencias personales. Son creativos y compasivos, valorando la armonía y la autenticidad en sus relaciones.'),
(7, 'INFP', 'Mediador', 'Los INFP son idealistas y reflexivos, conocidos como \"Mediadores\", que buscan entender sus valores y ayudar a otros en su crecimiento personal. Son creativos y compasivos, valorando la autenticidad y la conexión emocional en sus relaciones.'),
(8, 'INTP', 'Lógico', 'Los INTP son lógicos y analíticos, conocidos como \"Lógicos\", que priorizan el conocimiento y la comprensión. Se les reconoce por su interés en eliminar los detalles superficiales para llegar a los principios subyacentes de un sistema o idea. Pueden ser vistos como profesores despistados, altamente inteligentes, que disfrutan desarrollando y organizando sus comprensiones subjetivas en sistemas coherentes. Son flexibles y tolerantes, pero pueden volverse inflexibles cuando se desafían sus creencias.'),
(9, 'ESTP', 'Emprendedor', 'Los ESTP son enérgicos y prácticos, conocidos como \"Empresarios\", que disfrutan enfrentando desafíos y actuando en el momento. Son sociables y audaces, tomando decisiones basadas en hechos con un enfoque en obtener resultados tangibles.'),
(10, 'ESFP', 'Animador', 'Los ESFP son espontáneos y carismáticos, conocidos como \"Animadores\", que disfrutan viviendo el momento y animando a los demás. Son enérgicos y afectuosos, prefiriendo la acción y la emoción sobre la planificación y la reflexión.'),
(11, 'ENFP', 'Activista', 'Los ENFP son entusiastas y creativos, conocidos como \"Activistas\", que disfrutan explorando nuevas ideas y posibilidades. Son sociables y compasivos, inspirando a otros con su entusiasmo y visión optimista del futuro.'),
(12, 'ENTP', 'Innovador', 'Los ENTP son ingeniosos y visionarios, conocidos como \"Inventores\", que disfrutan desafiando el status quo y explorando nuevas perspectivas. Son ingeniosos y curiosos, buscando constantemente entender cómo funcionan las cosas y cómo pueden mejorarse.'),
(13, 'ESTJ', 'Ejecutivo', 'Los ESTJ son organizados y responsables, conocidos como \"Supervisores\", que valoran la estructura y el orden en su vida y trabajo. Son pragmáticos y decididos, tomando decisiones basadas en hechos con un enfoque en el logro de resultados tangibles.'),
(14, 'ESFJ', 'Cónsul', 'Los ESFJ son serviciales y sociables, conocidos como \"Cónsules\", que se preocupan profundamente por el bienestar de los demás. Son tradicionales y compasivos, disfrutando de las relaciones cercanas y las actividades que les permiten ayudar a los demás.'),
(15, 'ENFJ', 'Protagonista', 'Los ENFJ son carismáticos y compasivos, conocidos como \"Protagonistas\", que inspiran a otros con su visión y liderazgo. Son sociables y empáticos, comprometidos con el crecimiento personal y la construcción de relaciones significativas.'),
(16, 'ENTJ', 'Comandante', 'Los ENTJ son decididos y visionarios, conocidos como \"Comandantes\", que buscan liderar y organizar a otros para lograr sus objetivos. Son estratégicos y directivos, tomando decisiones rápidas y eficientes con un enfoque en el logro de resultados a largo plazo.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preguntas`
--

CREATE TABLE `preguntas` (
  `id` int(11) NOT NULL,
  `question` varchar(255) NOT NULL,
  `type` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `preguntas`
--

INSERT INTO `preguntas` (`id`, `question`, `type`) VALUES
(1, 'Haces nuevos amigos con regularidad.', 'focus'),
(2, 'Dedicas gran parte de tu tiempo libre a explorar temas aleatorios que despiertan tu interés.', 'information'),
(3, 'Ver llorar a otras personas puede hacer que sientas ganas de llorar tú también.', 'outerlife'),
(4, 'Sueles hacer un plan de reserva para un plan de reserva.', 'outerlife'),
(5, 'Sueles mantener la calma, incluso bajo mucha presión.', 'focus'),
(6, 'En los actos sociales, rara vez intentas presentarte a gente nueva y sueles hablar con los que ya conoces.', 'focus'),
(7, 'Prefieres terminar por completo un proyecto antes de empezar otro.', 'outerlife'),
(8, 'Controlas más tus emociones que ellas a ti.', 'decisions'),
(9, 'Te gusta utilizar herramientas de organización como agendas y listas.', 'outerlife'),
(10, 'Incluso un pequeño error puede hacerte dudar de tus capacidades y conocimientos generales.', 'decisions'),
(11, 'Te sientes cómodo acercándote a alguien que te parece interesante y entablando una conversación.', 'focus'),
(12, 'No te interesa demasiado discutir las diversas interpretaciones y análisis de las obras creativas.', 'information'),
(13, 'Te gusta más seguir a tu cabeza que a tu corazón.', 'decisions'),
(14, 'Sueles preferir hacer lo que te apetece en cada momento en lugar de planificar una rutina diaria concreta.', 'outerlife'),
(15, 'Rara vez te preocupas por causar una buena impresión a las personas que conoces.', 'focus'),
(16, 'Te gusta participar en actividades de grupo.', 'focus'),
(17, 'Te gustan los libros y las películas que te hacen pensar en tu propia interpretación del final.', 'information'),
(18, 'Tu felicidad proviene más de ayudar a los demás a conseguir cosas que de tus propios logros.', 'outerlife'),
(19, 'Te interesan tantas cosas que te resulta difícil elegir qué probar a continuación.', 'information'),
(20, 'Eres propenso a preocuparte de que las cosas empeoren.', 'decisions'),
(21, 'Evitas el liderazgo en grupos.', 'focus'),
(22, 'No eres una persona artística.', 'focus'),
(23, 'Crees que el mundo sería mejor si la gente se basara más en la racionalidad y menos en sus sentimientos.', 'decisions'),
(24, 'Prefieres hacer tus tareas antes de permitirte relajarte.', 'outerlife'),
(25, 'Te gusta ver discutir a la gente.', 'outerlife'),
(26, 'Tiendes a evitar llamar la atención.', 'focus'),
(27, 'Tu humor puede cambiar muy rápidamente.', 'focus'),
(28, 'Pierdes la paciencia con las personas que no son tan eficientes como tú.', 'decisions'),
(29, 'A menudo acabas haciendo las cosas en el último momento.', 'outerlife'),
(30, 'Siempre te ha fascinado la cuestión de qué ocurre después de la muerte, si es que ocurre algo.', 'outerlife'),
(31, 'Sueles preferir estar rodeado de otros que solo.', 'focus'),
(32, 'Te aburres o pierdes el interés cuando la discusión se vuelve muy teórica.', 'information'),
(33, 'Te resulta fácil empatizar con una persona cuyas experiencias son muy diferentes de las tuyas.', 'focus'),
(34, 'Sueles aplazar la toma de decisiones el mayor tiempo posible.', 'outerlife'),
(35, 'Rara vez reconsideras las decisiones que has tomado.', 'decisions'),
(36, 'Después de una semana larga y agotadora, un acto social animado es justo lo que necesitas.', 'focus'),
(37, 'Te gusta ir a museos de arte.', 'information'),
(38, 'Te cuesta comprender los sentimientos de los demás.', 'focus'),
(39, 'Te gusta tener una lista de tareas para cada día.', 'outerlife'),
(40, 'Rara vez te sientes inseguro.', 'focus'),
(41, 'Evitas llamar por teléfono.', 'outerlife'),
(42, 'Sueles pasar mucho tiempo intentando comprender puntos de vista muy diferentes a los tuyos.', 'information'),
(43, 'En tu círculo social, sueles ser tú quien contacta con tus amigos e inicia las actividades.', 'focus'),
(44, 'Si tus planes se ven interrumpidos, tu máxima prioridad es retomarlos lo antes posible.', 'outerlife'),
(45, 'Todavía te molestan los errores que cometiste hace mucho tiempo.', 'decisions'),
(46, 'Rara vez contemplas las razones de la existencia humana o el sentido de la vida.', 'outerlife'),
(47, 'Controlas más tus emociones que ellas a ti.', 'decisions'),
(48, 'Te cuidas mucho de no hacer quedar mal a la gente, incluso cuando es completamente culpa suya.', 'decisions'),
(49, 'Tu estilo personal de trabajo se acerca más a las explosiones espontáneas de energía que a los esfuerzos organizados y constantes.', 'outerlife'),
(50, 'Cuando alguien tiene una buena opinión de ti, te preguntas cuánto tardará en sentirse decepcionado contigo.', 'focus'),
(51, 'Te encantaría un trabajo en el que tuvieras que trabajar en equipo la mayor parte del tiempo.', 'focus'),
(52, 'Crees que reflexionar sobre cuestiones filosóficas abstractas es una pérdida de tiempo.', 'decisions'),
(53, 'Te sientes más atraído por lugares con ambientes bulliciosos y ajetreados que por lugares tranquilos e íntimos.', 'focus'),
(54, 'Sabes a primera vista cómo se siente una persona.', 'information'),
(55, 'A menudo te sientes abrumado.', 'focus'),
(56, 'Completas las cosas metódicamente sin saltarte ningún paso.', 'outerlife'),
(57, 'Te intrigan mucho las cosas tachadas de controvertidas.', 'information'),
(58, 'Dejarías pasar una buena oportunidad si pensaras que otra persona la necesita más.', 'outerlife'),
(59, 'Te cuesta cumplir los plazos.', 'decisions'),
(60, 'Confías en que las cosas te saldrán bien.', 'decisions');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `username` varchar(255) NOT NULL,
  `mbti` varchar(4) NOT NULL,
  `focus` int(11) NOT NULL,
  `information` int(11) NOT NULL,
  `decisions` int(11) NOT NULL,
  `outerlife` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `username`, `mbti`, `focus`, `information`, `decisions`, `outerlife`) VALUES
(1, 'Michillas', 'INTP', -1, 0, 0, 0),
(2, 'jj', 'ESFP', 43, 12, 20, 18),
(3, 'test', 'ENTP', 0, 0, 0, 0),
(4, 'Vitaliy', 'ENTP', 4, 7, 9, 18);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `character`
--
ALTER TABLE `character`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `mbti`
--
ALTER TABLE `mbti`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `mbti` (`mbti`);

--
-- Indices de la tabla `preguntas`
--
ALTER TABLE `preguntas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `character`
--
ALTER TABLE `character`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;

--
-- AUTO_INCREMENT de la tabla `mbti`
--
ALTER TABLE `mbti`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `preguntas`
--
ALTER TABLE `preguntas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
